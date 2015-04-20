PBS Torque Resources Manager is one of the best open-source load balancing clusters. 

This project will create an API to interface Java with PBS Torque through an Object Oriented Model not through the command-line. 
This is anticipated to simplify the task of integeratation of your Java Solutions. 

API Doc can be found at: http://www.nubios.nileu.edu.eg/pbs4java/



#How to get started with the API

##Introduction

This page shows you how to use the API

### How to queue a job:

  + Add the jar to your classpath.
  + create your solution as a shell file.
  + Create instance of the job class 
  
```java
pbsTorque.Job j = new pbsTorque.Job("test1","path/to/shellfile");
j.queue();
```

### Get the Job Information

```java
pbsTorque.Job j = pbsTorque.Job.getJobById("JOB_ID");
system.out.println(j.getStatus);
```

### Search for a job by name

API allows you to search for job id for a job specifying a certain crateria.
```java
String[] foundJobs = pbsTorque.Job.SearchJobsByName("test",false);
for (int i=0; i<foundJobs.Length;i++)
{
pbsTorque.Job j = pbsTorque.Job.getJobById(foundJobs[i]);
system.out.println(j.getStatus);
}
```
  
