# Priority Panda Backend

**Priority Panda** is a backend service designed to help users efficiently manage and prioritize tasks. The system provides a comprehensive API for users to create, prioritize, track, and manage tasks, as well as receive timely reminders for important deadlines. It’s an intuitive tool for managing both personal and professional tasks with ease.

The backend is built with scalability in mind, ensuring it can support multiple users and handle various task-related operations such as priority assignment, scheduling, updating, and task completion. Whether you’re an individual organizing your daily tasks or a team collaborating on a project, Priority Panda provides the tools needed to stay organized and on top of deadlines.

## Features

- **User Authentication**: Secure user registration and login with JWT authentication.
- **Task Management**: Create, update, delete, and complete tasks, all with configurable priority levels.
- **Task Scheduling**: Set deadlines and receive notifications for upcoming or overdue tasks.
- **Priority Management**: Assign different priority levels (e.g., low, medium, high) to tasks for better task organization.
- **Comprehensive Task Tracking**: View tasks based on their completion status (pending, in progress, completed).
- **API Rate Limiting**: Control the flow of requests to the API for enhanced security and resource management.
- **User Profile Management**: Users can manage their account information and settings.

## Technologies Used

- **Node.js**: Backend runtime environment to handle API requests and manage asynchronous operations.
- **Express.js**: Web framework used to build the RESTful API.
- **MongoDB**: NoSQL database for storing user and task data in a scalable way.
- **Mongoose**: ODM (Object Data Modeling) library for MongoDB that facilitates interactions between the app and database.
- **JWT (JSON Web Tokens)**: Secure authentication mechanism for user login and session management.
- **Bcrypt.js**: Used for hashing passwords and ensuring user data security.
- **Dotenv**: Manages environment variables to keep configuration settings and sensitive data secure.
- **Nodemailer**: For sending email notifications or reminders for important tasks.

## API Endpoints

The **Priority Panda** backend exposes a set of RESTful API endpoints for interacting with tasks and managing user data. All endpoints are designed to ensure simplicity and ease of use.
