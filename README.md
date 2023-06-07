# SENG-2050 - Web Engineering Group Project

Authors: Simon GAUTIER (c3424883), Nathan VILMEN (c3424816)

Connecting to the SQL Server Database in Azure Data Studio
Open Azure Data Studio:
- Click on the "New Connection" button in the toolbar, or go to the "Connections" pane on the left side and click on the "+ New Connection" button.
- In the "Server" field, enter localhost since the database is hosted locally. If the database is hosted on a different server, enter the appropriate server name or IP address.
- In the "Authentication type" dropdown, select "SQL Login."
- Enter the username and password specified in the context configuration:
- Username: SA
- Password: Seng2050!
- In the "Server Group" field, you can choose to leave it blank or provide a server group name for organizing your connections.
- In the "Database" field, enter c3424883_db as the name of the database you want to connect to.
- In the "Connection Options" section, click on the "Advanced" button to expand the advanced options.
- In the "Additional Connection Parameters" field, enter encrypt=true;trustServerCertificate=true;.
- Click the "Connect" button to establish the connection to the database.