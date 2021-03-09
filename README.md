# CoopedIn

**Company Name:** CoopedIn

**Engineering Team**

Min Cheng, Arthur Skok, Henry Son, Ernesto Colon 


#### Description: Web-based Recruiting Platform
A platform where companies can post job information and create a company webpage, and where potential job-seekers can search for and apply for the positions they want. Both the users and the companies can send feedback forms to the admin of the platform. The platform is designed to simplify the job hunting process. 


#### Core Requirements
Modules: admin, users, companies (recruiters)
Admins
Applications for User and Company accounts are handled via Admin
Can manage (view/add/delete) the registered recruiters
Process feedback form from users and companies
Users and recruiters’ info security

#### Job-seekers
An account with basic information (eg. resume, education info, work experience, target positions/fields)
Permission to view and search for jobs that Recruiters/Companies post
Can apply for the listed jobs and create applications (in application list)
Can view the application status (eg. application submitted, Reviewing by HR, Offer/Defer)

#### Companies/Recruiters
An account with legal certifications
Has company introduction and the list of open positions in the company webpage (managed by the company account)
Append database that Admin manages with specific jobs/positions for their company
Manage and update the status of the applications received by the company
Manage the positions that are open in the company (view/add/delete/edit the positions listed)

#### Stretch Requirements (at least one)
For the users, they can get positions recommendation feed based on their search history, their work experience, and their target fields
Direct message functions
Web browser based interface first → mobile browsing

#### 03.08.21 Sample outputs --> Filter job feed by user's location
'''
**get user with id 1**

$ curl -s localhost:4567/user/1 | jq

{
  "id": "1",
  "name": "John S.",
  "location": [
    "NY"
  ]
}

**get user feed filtered by location**

$ curl -s localhost:4567/user/1/feed | jq

{
  "jobPostings": [
    {
      "jobPostItems": [
        {
          "id": "1",
          "available": true,
          "jobTitle": "R&D Engineer",
          "company": "Adobe",
          "location": "NY",
          "jobType": "FullTime"
        },
        {
          "id": "2",
          "available": true,
          "jobTitle": "SW Engineer",
          "company": "Adobe",
          "location": "NY",
          "jobType": "FullTime"
        },
        {
          "id": "3",
          "available": true,
          "jobTitle": "Marketing Manager",
          "company": "Adobe",
          "location": "NY",
          "jobType": "FullTime"
        },
        {
          "id": "8",
          "available": true,
          "jobTitle": "Professor",
          "company": "NYU",
          "location": "NY",
          "jobType": "FullTime"
        }
      ]
    }
  ]
}

$ curl -s localhost:4567/user/2 | jq
{
  "id": "2",
  "name": "Mary S.",
  "location": [
    "NJ"
  ]
}


$ curl -s localhost:4567/user/2/feed | jq

{
  "jobPostings": [
    {
      "jobPostItems": [
        {
          "id": "4",
          "available": true,
          "jobTitle": "SW Engineer",
          "company": "Adobe",
          "location": "NJ",
          "jobType": "FullTime"
        },
        {
          "id": "5",
          "available": true,
          "jobTitle": "Mechanical Engineer",
          "company": "Amazon",
          "location": "NJ",
          "jobType": "Coop"
        },
        {
          "id": "6",
          "available": true,
          "jobTitle": "Quality Engineer",
          "company": "Amazon",
          "location": "NJ",
          "jobType": "PartTime"
        },
        {
          "id": "7",
          "available": true,
          "jobTitle": "Backend Engineer",
          "company": "Amazon",
          "location": "NJ",
          "jobType": "Internship"
        },
        {
          "id": "9",
          "available": true,
          "jobTitle": "Lawyer",
          "company": "Aetna",
          "location": "NJ",
          "jobType": "FullTime"
        }
      ]
    }
  ]
}
'''
