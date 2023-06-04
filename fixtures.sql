CREATE DATABASE c3424883_db;
GO

USE c3424883_db;

-- For Dev purposes (not in a production environment)
CREATE LOGIN adminSENG2050 WITH PASSWORD='adminSENG2050';

CREATE USER adminSENG2050 FOR LOGIN adminSENG2050;

GRANT SELECT, INSERT, UPDATE, DELETE TO adminSENG2050;

CREATE TABLE Users(
                        userID int IDENTITY PRIMARY KEY,
                        userName nvarchar(25) NOT NULL,
                        password nvarchar(100) NOT NULL,
                        firstName nvarchar(35) NOT NULL,
                        surname nvarchar(35) NOT NULL,
                        email nvarchar(255) NOT NULL    UNIQUE,
                        phoneNum nvarchar(12) NOT NULL,
                        isStaff tinyint NOT NULL DEFAULT 0,
                        isManager tinyint NOT NULL DEFAULT 0
);

CREATE TABLE Categories(
    categoryName varchar(25) PRIMARY KEY
);

CREATE TABLE Issues(
                      issueID int IDENTITY PRIMARY KEY,
                      reporterID int NOT NULL,
                      ITStaffID int NOT NULL,
                      title nvarchar(55) NOT NULL,
                      description nvarchar(300) NOT NULL,
                      resolutionDetails nvarchar(300),
                      reportedDate DateTime NOT NULL,
                      resolvedDate DateTime,
                      state nvarchar(50) NOT NULL,
                      category varchar(25) NOT NULL,
                      isKBArticle tinyint NOT NULL	DEFAULT 0,

                      FOREIGN KEY(reporterID) REFERENCES Users(userID) ON UPDATE CASCADE ON DELETE NO ACTION,
                      FOREIGN KEY(ITStaffID) REFERENCES Users(userID),
                      FOREIGN KEY(category) REFERENCES Categories(categoryName) ON UPDATE CASCADE ON DELETE NO ACTION

);

CREATE TABLE Comments(
                        commentID int IDENTITY PRIMARY KEY,
                        issueID int NOT NULL,
                        userID int NOT NULL,
                        userName nvarchar(25) NOT NULL,
                        text nvarchar(300) NOT NULL,
                        date DateTime NOT NULL,

                        FOREIGN KEY(issueID) REFERENCES Issues(issueID) ON UPDATE CASCADE ON DELETE NO ACTION,
                        FOREIGN KEY(userId) REFERENCES Users(userID)
);


CREATE TABLE Keywords(
                        keywordID int IDENTITY PRIMARY KEY,
                        keyword nvarchar(25) NOT NULL,
                        issueID int NOT NULL,

                        FOREIGN KEY(issueID) REFERENCES Issues(issueID) ON UPDATE CASCADE ON DELETE NO ACTION
);

INSERT INTO Categories VALUES ('Network');
INSERT INTO Categories VALUES ('Software');
INSERT INTO Categories VALUES ('Hardware');
INSERT INTO Categories VALUES ('Email');
INSERT INTO Categories VALUES ('Account');

INSERT INTO Users (userName, password, firstName, surname, email, phoneNum, isStaff, isManager)
VALUES ('johnDoe', '238f32a8338b7e68b7adf60f7fa34785f9b208dd', 'John', 'Doe', 'john.doe@example.com', '1234567890', 0, 1);

INSERT INTO Users (userName, password, firstName, surname, email, phoneNum, isStaff, isManager)
VALUES ('janeSmith', '238f32a8338b7e68b7adf60f7fa34785f9b208dd', 'Jane', 'Smith', 'jane.smith@example.com', '9876543210', 1, 0);

INSERT INTO Users (userName, password, firstName, surname, email, phoneNum, isStaff, isManager)
VALUES ('aliceJohnson', '238f32a8338b7e68b7adf60f7fa34785f9b208dd', 'Alice', 'Johnson', 'alice.johnson@example.com', '5551234567', 0, 0);

INSERT INTO Users (userName, password, firstName, surname, email, phoneNum, isStaff, isManager)
VALUES ('bobWilliams', '238f32a8338b7e68b7adf60f7fa34785f9b208dd', 'Bob', 'Williams', 'bob.williams@example.com', '9876543210', 1, 1);

INSERT INTO Users (userName, password, firstName, surname, email, phoneNum, isStaff, isManager)
VALUES ('sarahBrown', '238f32a8338b7e68b7adf60f7fa34785f9b208dd', 'Sarah', 'Brown', 'sarah.brown@example.com', '1234567890', 1, 0);


-- Inserting data into the "Issues" table
INSERT INTO Issues (reporterID, ITStaffID, title, description, resolutionDetails, reportedDate, resolvedDate, state, category, isKBArticle)
VALUES (1, 2, 'Network Connectivity Issues', 'Experiencing intermittent network connectivity', 'Resolved by restarting the router', '2023-05-01', '2023-05-02', 'Resolved', 'Network', 1);

INSERT INTO Issues (reporterID, ITStaffID, title, description, reportedDate, state, category, isKBArticle)
VALUES (2, 3, 'Software Installation Error', 'Encountering error during software installation', '2023-05-03', 'Open', 'Software', 0);

INSERT INTO Issues (reporterID, ITStaffID, title, description, reportedDate, state, category, isKBArticle)
VALUES (3, 1, 'Printer Not Responding', 'Printer is not responding to print requests', '2023-05-04', 'Open', 'Hardware', 0);

INSERT INTO Issues (reporterID, ITStaffID, title, description, resolutionDetails, reportedDate, resolvedDate, state, category, isKBArticle)
VALUES (2, 3, 'Email Access Issues', 'Unable to access email account', 'Resolved by resetting the password', '2023-05-05', '2023-05-06', 'Resolved', 'Email', 1);

INSERT INTO Issues (reporterID, ITStaffID, title, description, reportedDate, state, category, isKBArticle)
VALUES (1, 2, 'Website Performance Degradation', 'Experiencing slow website performance', '2023-05-07', 'Open', 'Network', 0);


-- Inserting data into the "Comments" table
INSERT INTO Comments (issueID, userID, userName, text, date)
VALUES (1, 1, 'johnDoe', 'I have experienced the same issue.', '2023-05-01 10:00:00');

INSERT INTO Comments (issueID, userID, userName, text, date)
VALUES (1, 2, 'janeSmith', 'The issue seems to be resolved now.', '2023-05-02 11:30:00');

INSERT INTO Comments (issueID, userID, userName, text, date)
VALUES (2, 3, 'aliceJohnson', 'I will investigate the issue further.', '2023-05-03 09:15:00');

INSERT INTO Comments (issueID, userID, userName, text, date)
VALUES (3, 1, 'johnDoe', 'Please check the printer connections.', '2023-05-04 14:20:00');

INSERT INTO Comments (issueID, userID, userName, text, date)
VALUES (3, 2, 'janeSmith', 'I will order a new printer.', '2023-05-05 16:45:00');







