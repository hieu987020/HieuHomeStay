use PRJ321
Create Table  (
	Username VARCHAR(50) PRIMARY KEY,
    [Password] VARCHAR(50),
    RoleID INT,
    InfoID INT,
	CONSTRAINT one_account UNIQUE(InfoID)
)