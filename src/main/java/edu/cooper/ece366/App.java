package edu.cooper.ece366;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.cooper.ece366.handler.Handler;
import edu.cooper.ece366.service.FeedServiceImpl;
import edu.cooper.ece366.store.CompanyStoreImpl;
import edu.cooper.ece366.store.JobStoreImpl;
import edu.cooper.ece366.store.UserStoreImpl;
import io.norberg.automatter.gson.AutoMatterTypeAdapterFactory;
import spark.Spark;

import static edu.cooper.ece366.store.UserStoreImpl.addUser;
import static spark.Spark.get;
import static spark.Spark.initExceptionHandler;

public class App {
  public static void main(String[] args) {
    Gson gson =
        new GsonBuilder().registerTypeAdapterFactory(new AutoMatterTypeAdapterFactory()).create();

    initExceptionHandler(Throwable::printStackTrace);

    Handler handler = new Handler(new UserStoreImpl(), new FeedServiceImpl(new JobStoreImpl()),
      new CompanyStoreImpl());

    get("/ping", (req, res) -> "OK");
    get("/user/:userId", (req, res) -> handler.getUser(req), gson::toJson);
    Spark.get("/user/:userId/feed", (req, res) -> handler.getFeed(req), gson::toJson);
    Spark.get("/company/:companyId/feed", (req,res) -> handler.getFeedByCompany(req), gson::toJson);

    // trying out a POST command to insert a new user
    Spark.post("/newUser", (req, res) -> {
      String id = req.queryParams("id");
      String name = req.queryParams("name");
      String location = req.queryParams("location");

      // store
      addUser(id, name, location);
      return ("Success! New User Created with id = " + id + "\n");
    });
  }
}
