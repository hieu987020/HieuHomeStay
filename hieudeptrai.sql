Create Database HieuHomeStay
use HieuHomeStay
---Accounts
Create Table Accounts (
	Username VARCHAR(50) PRIMARY KEY,
    [Password] VARCHAR(50),
    RoleID INT,
    InfoID INT,
	CONSTRAINT one_account UNIQUE(InfoID)
)
Create Table Roles (
	ID INT IDENTITY(1,1) PRIMARY KEY,
    Name VARCHAR(50),
	CONSTRAINT one_roleName UNIQUE(Name)
)
Create Table Informations (
	ID INT IDENTITY(1,1) PRIMARY KEY,
    Name VARCHAR(50),
	Phone VARCHAR(50),
	Email VARCHAR(50),
	Sex VARCHAR(50),
	LevelID INT,
	Coin INT 
)
Create Table Levels (
	ID INT IDENTITY(1,1) PRIMARY KEY,
    Name VARCHAR(50),
	[Des] INT,
	CONSTRAINT one_levelName UNIQUE(Name)
)
Create Table Products (
	ID INT IDENTITY(1,1) PRIMARY KEY,
	Name VARCHAR(50),
	Quantity INT,
	Price FLOAT,
	Coin INT,
	[Type] VARCHAR(50),
	Source VARCHAR(50),
	isDeleted BIT
)
Create Table ProductDetails(
	ID INT IDENTITY(1,1) PRIMARY KEY,
	ProID INT,
	BillID INT,
	Quantity INT,
	Price FLOAT
)
Create Table Rooms(
	ID INT IDENTITY(1,1) PRIMARY KEY,
	Name VARCHAR(50),
	[Des] VARCHAR(500),
	Price FLOAT,
	isBooked BIT,
	Source VARCHAR(50),
	isDeleted BIT
)
Create Table RoomDetails(
	ID INT IDENTITY(1,1) PRIMARY KEY,
	RoomID INT,
	BillID INT, 
	DateFrom DATETIME,
	DateTo DATETIME,
	Price FLOAT
)
Create Table [Services](
	ID INT IDENTITY(1,1) PRIMARY KEY,
	Name VARCHAR(50),
	Price FLOAT,
	[Des] VARCHAR(500),
	Source VARCHAR(50),
	isDeleted BIT
)
Create Table ServiceDetails(
	ID INT IDENTITY(1,1) PRIMARY KEY,
	SerID INT,
	BillID INT,
	Price FLOAT
)
Create Table Bills(
	ID INT IDENTITY(1,1) PRIMARY KEY,
	InfoID INT,
	StaffID INT,
	DateFrom DATETIME, 
	DateTo DATETIME,
	SumBefore FLOAT,
	MoneyDiscount FLOAT,
	SumAfter FLOAT,
	[Time] DATETIME,
	IsApproved BIT
)
Create Table ProductCoinDetails(
	ID INT IDENTITY(1,1) PRIMARY KEY,
	ProductID INT,
	BillCoinID INT,
	Quantity INT,
	Coin INT
)
Create Table BillCoins(
	ID INT IDENTITY(1,1) PRIMARY KEY,
	InfoID INT,
	Coin INT,
	[Time] DATETIME
)
Create Table HistoryStaffs(
	ID INT IDENTITY(1,1) PRIMARY KEY,
	InfoID INT,
	BillID INT,
	[Des] VARCHAR(500),
	[Time] DATETIME,
	CONSTRAINT one_actionBill UNIQUE(BillID)
)
