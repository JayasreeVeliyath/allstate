## ✨ About the Project

Spring application to demonstrate Flowable. The premise is illustrated in the flowchart below.


![Alt text](treat-request-flowchart.png?raw=true "Title")

##  Usage

>Note: Maven(3.8.6) has to be installed.

- Run the file FlowablePocApplication.java as a Java Application from an IDE of your choice. 
The application runs at 

```sh
http://localhost:8080
```

- The application exposes 3 REST APIs to start a process and trigger an event, force gateway decision and complete the process.

  The postman collection - **FlowablePOC.postman_collection.json**, found in the root folder, can be imported into Postman and run in the specified order.
    

   1. **Treat Request** - Returns an id for the created process.
   2. **Review Treat Request**  - Pass the id returned from the previous API response , along with "true/false" to approve/reject the request.
   3. **Get Treat Requests** - Gets the list of all the active processes.


## Author

👤 **Jayasree Veliyathu**

## Acknowledgments

[Baeldung](https://www.baeldung.com/flowable)