package edu.cooper.ece366.service;

import edu.cooper.ece366.model.*;
import edu.cooper.ece366.store.JobStore;

import java.util.List;
import java.util.stream.Collectors;

public class FeedServiceImpl implements FeedService {

    private final JobStore jobStore;

    public FeedServiceImpl(JobStore jobStore) { this.jobStore = jobStore; }

    @Override
    public Feed getFeedForUser(final User user) {
        List<Shelf> shelves =
                user.location().stream()
                        .map(jobStore::getByLocation)
                        .filter(list -> !list.isEmpty())
                        .map(items ->
                                new ShelfBuilder()
                                        .shelfItems(items)
                                        .build())
                        .collect(Collectors.toList());

        return new FeedBuilder().shelves(shelves).build();
    }
}

/*
EC Comments 03.08.21: This feed service is extremely contrived. It would only work if the jobStore does not contain
multiple 'duplicate' entries for the location attribute. In other words, as it stands right now, we cannot have more
than one job listed per city.

This is the error I am getting:

[INFO] --- exec-maven-plugin:3.0.0:exec (default-cli) @ CoopedIn ---
Exception in thread "main" java.lang.ExceptionInInitializerError
	at edu.cooper.ece366.App.main(App.java:22)
Caused by: java.lang.IllegalStateException: Duplicate key NY (attempted merging values Job{available=true, jobTitle=R&D Engineer, company=Adobe, location=NY, jobType=FullTime} and Job{available=true, jobTitle=Mechanical Engineer, company=Amazon, location=NY, jobType=FullTime})
	at java.base/java.util.stream.Collectors.duplicateKeyException(Collectors.java:133)
	at java.base/java.util.stream.Collectors.lambda$uniqKeysMapAccumulator$1(Collectors.java:180)
	at java.base/java.util.stream.ReduceOps$3ReducingSink.accept(ReduceOps.java:169)
	at java.base/java.util.AbstractList$RandomAccessSpliterator.forEachRemaining(AbstractList.java:720)
	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
	at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
	at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
	at edu.cooper.ece366.store.JobStoreImpl.<clinit>(JobStoreImpl.java:39)
	... 1 more
[ERROR] Command execution failed.
 */