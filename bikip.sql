USE [master]
GO
/****** Object:  Database [HieuHomeStay]    Script Date: 25/08/2019 05:14:30 ******/
CREATE DATABASE [HieuHomeStay]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'HieuHomeStay', FILENAME = N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\HieuHomeStay.mdf' , SIZE = 4288KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'HieuHomeStay_log', FILENAME = N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\HieuHomeStay_log.ldf' , SIZE = 1072KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [HieuHomeStay] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [HieuHomeStay].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [HieuHomeStay] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [HieuHomeStay] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [HieuHomeStay] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [HieuHomeStay] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [HieuHomeStay] SET ARITHABORT OFF 
GO
ALTER DATABASE [HieuHomeStay] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [HieuHomeStay] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [HieuHomeStay] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [HieuHomeStay] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [HieuHomeStay] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [HieuHomeStay] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [HieuHomeStay] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [HieuHomeStay] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [HieuHomeStay] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [HieuHomeStay] SET  ENABLE_BROKER 
GO
ALTER DATABASE [HieuHomeStay] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [HieuHomeStay] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [HieuHomeStay] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [HieuHomeStay] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [HieuHomeStay] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [HieuHomeStay] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [HieuHomeStay] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [HieuHomeStay] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [HieuHomeStay] SET  MULTI_USER 
GO
ALTER DATABASE [HieuHomeStay] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [HieuHomeStay] SET DB_CHAINING OFF 
GO
ALTER DATABASE [HieuHomeStay] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [HieuHomeStay] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [HieuHomeStay] SET DELAYED_DURABILITY = DISABLED 
GO
USE [HieuHomeStay]
GO
/****** Object:  Table [dbo].[Accounts]    Script Date: 25/08/2019 05:14:30 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Accounts](
	[Username] [varchar](50) NOT NULL,
	[Password] [varchar](50) NULL,
	[RoleID] [int] NULL,
	[InfoID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[BillCoins]    Script Date: 25/08/2019 05:14:30 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BillCoins](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[InfoID] [int] NULL,
	[Coin] [int] NULL,
	[Time] [datetime] NULL,
	[isApproved] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Bills]    Script Date: 25/08/2019 05:14:30 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bills](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[InfoID] [int] NULL,
	[StaffID] [int] NULL,
	[DateFrom] [datetime] NULL,
	[DateTo] [datetime] NULL,
	[SumBefore] [float] NULL,
	[MoneyDiscount] [float] NULL,
	[SumAfter] [float] NULL,
	[Time] [datetime] NULL,
	[IsApproved] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HistoryStaffs]    Script Date: 25/08/2019 05:14:30 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HistoryStaffs](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[InfoID] [int] NULL,
	[Des] [varchar](500) NULL,
	[Time] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Informations]    Script Date: 25/08/2019 05:14:30 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Informations](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [varchar](50) NULL,
	[Phone] [varchar](50) NULL,
	[Email] [varchar](50) NULL,
	[Sex] [varchar](50) NULL,
	[LevelID] [int] NULL,
	[Coin] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Levels]    Script Date: 25/08/2019 05:14:30 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Levels](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [varchar](50) NULL,
	[Des] [int] NULL,
	[Condition] [varchar](500) NULL,
 CONSTRAINT [PK__Levels__3214EC277771CA7C] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ProductCoinDetails]    Script Date: 25/08/2019 05:14:30 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProductCoinDetails](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ProductID] [int] NULL,
	[BillCoinID] [int] NULL,
	[Quantity] [int] NULL,
	[Coin] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ProductDetails]    Script Date: 25/08/2019 05:14:30 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProductDetails](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ProID] [int] NULL,
	[BillID] [int] NULL,
	[Quantity] [int] NULL,
	[Price] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Products]    Script Date: 25/08/2019 05:14:30 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Products](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [varchar](50) NULL,
	[Quantity] [int] NULL,
	[Price] [float] NULL,
	[Coin] [int] NULL,
	[Type] [varchar](50) NULL,
	[Source] [varchar](50) NULL,
	[isDeleted] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Roles]    Script Date: 25/08/2019 05:14:30 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Roles](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[RoomDetails]    Script Date: 25/08/2019 05:14:30 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RoomDetails](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[RoomID] [int] NULL,
	[BillID] [int] NULL,
	[DateFrom] [datetime] NULL,
	[DateTo] [datetime] NULL,
	[Price] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Rooms]    Script Date: 25/08/2019 05:14:30 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Rooms](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [varchar](50) NULL,
	[Des] [varchar](500) NULL,
	[Price] [float] NULL,
	[isBooked] [bit] NULL,
	[Source] [varchar](50) NULL,
	[isDeleted] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ServiceDetails]    Script Date: 25/08/2019 05:14:30 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ServiceDetails](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[SerID] [int] NULL,
	[BillID] [int] NULL,
	[Price] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Services]    Script Date: 25/08/2019 05:14:30 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Services](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [varchar](50) NULL,
	[Price] [float] NULL,
	[Des] [varchar](500) NULL,
	[Source] [varchar](50) NULL,
	[isDeleted] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Accounts] ([Username], [Password], [RoleID], [InfoID]) VALUES (N'hieu', N'hieu', 1, 1)
INSERT [dbo].[Accounts] ([Username], [Password], [RoleID], [InfoID]) VALUES (N'ngu', N'ngu', 2, 16)
INSERT [dbo].[Accounts] ([Username], [Password], [RoleID], [InfoID]) VALUES (N'tien', N'tien', 2, 17)
SET IDENTITY_INSERT [dbo].[HistoryStaffs] ON 

INSERT [dbo].[HistoryStaffs] ([ID], [InfoID], [Des], [Time]) VALUES (19, 17, N'Update Room. Room ID is 1', CAST(N'2019-08-24 22:15:48.000' AS DateTime))
INSERT [dbo].[HistoryStaffs] ([ID], [InfoID], [Des], [Time]) VALUES (20, 17, N'Update Product. Product ID is 1', CAST(N'2019-08-24 22:15:53.000' AS DateTime))
INSERT [dbo].[HistoryStaffs] ([ID], [InfoID], [Des], [Time]) VALUES (21, 17, N'Update Service. Service ID is 1', CAST(N'2019-08-24 22:16:00.000' AS DateTime))
INSERT [dbo].[HistoryStaffs] ([ID], [InfoID], [Des], [Time]) VALUES (22, 17, N'Update Product. Product ID is 1', CAST(N'2019-08-25 03:27:12.000' AS DateTime))
INSERT [dbo].[HistoryStaffs] ([ID], [InfoID], [Des], [Time]) VALUES (23, 17, N'Update Product. Product ID is 2', CAST(N'2019-08-25 03:27:20.000' AS DateTime))
INSERT [dbo].[HistoryStaffs] ([ID], [InfoID], [Des], [Time]) VALUES (24, 17, N'Update Room. Room ID is 1', CAST(N'2019-08-25 03:36:18.000' AS DateTime))
INSERT [dbo].[HistoryStaffs] ([ID], [InfoID], [Des], [Time]) VALUES (25, 17, N'Maintenance Room. Room ID is 1', CAST(N'2019-08-25 03:36:19.000' AS DateTime))
INSERT [dbo].[HistoryStaffs] ([ID], [InfoID], [Des], [Time]) VALUES (26, 17, N'Update Room. Room ID is 1', CAST(N'2019-08-25 03:36:36.000' AS DateTime))
INSERT [dbo].[HistoryStaffs] ([ID], [InfoID], [Des], [Time]) VALUES (27, 17, N'Maintenance Room. Room ID is 1', CAST(N'2019-08-25 03:38:12.000' AS DateTime))
INSERT [dbo].[HistoryStaffs] ([ID], [InfoID], [Des], [Time]) VALUES (28, 17, N'Update Room. Room ID is 1', CAST(N'2019-08-25 03:38:18.000' AS DateTime))
INSERT [dbo].[HistoryStaffs] ([ID], [InfoID], [Des], [Time]) VALUES (29, 17, N'Maintenance Room. Room ID is 1', CAST(N'2019-08-25 03:39:01.000' AS DateTime))
INSERT [dbo].[HistoryStaffs] ([ID], [InfoID], [Des], [Time]) VALUES (30, 17, N'Update Room. Room ID is 1', CAST(N'2019-08-25 03:39:06.000' AS DateTime))
INSERT [dbo].[HistoryStaffs] ([ID], [InfoID], [Des], [Time]) VALUES (31, 17, N'Maintenance Product. Product ID is 1', CAST(N'2019-08-25 03:39:12.000' AS DateTime))
INSERT [dbo].[HistoryStaffs] ([ID], [InfoID], [Des], [Time]) VALUES (32, 17, N'Update Product. Product ID is 1', CAST(N'2019-08-25 03:39:18.000' AS DateTime))
INSERT [dbo].[HistoryStaffs] ([ID], [InfoID], [Des], [Time]) VALUES (33, 17, N'Maintenance Service. Service ID is 1', CAST(N'2019-08-25 03:39:48.000' AS DateTime))
INSERT [dbo].[HistoryStaffs] ([ID], [InfoID], [Des], [Time]) VALUES (34, 17, N'Update Service. Service ID is 1', CAST(N'2019-08-25 03:39:53.000' AS DateTime))
INSERT [dbo].[HistoryStaffs] ([ID], [InfoID], [Des], [Time]) VALUES (35, 17, N'Maintenance Room. Room ID is 1', CAST(N'2019-08-25 03:40:04.000' AS DateTime))
INSERT [dbo].[HistoryStaffs] ([ID], [InfoID], [Des], [Time]) VALUES (36, 17, N'Maintenance Room. Room ID is 2', CAST(N'2019-08-25 03:40:08.000' AS DateTime))
INSERT [dbo].[HistoryStaffs] ([ID], [InfoID], [Des], [Time]) VALUES (37, 17, N'Maintenance Room. Room ID is 374', CAST(N'2019-08-25 03:40:10.000' AS DateTime))
INSERT [dbo].[HistoryStaffs] ([ID], [InfoID], [Des], [Time]) VALUES (38, 17, N'Maintenance Room. Room ID is 375', CAST(N'2019-08-25 03:40:11.000' AS DateTime))
INSERT [dbo].[HistoryStaffs] ([ID], [InfoID], [Des], [Time]) VALUES (39, 17, N'Maintenance Room. Room ID is 376', CAST(N'2019-08-25 03:40:13.000' AS DateTime))
INSERT [dbo].[HistoryStaffs] ([ID], [InfoID], [Des], [Time]) VALUES (40, 17, N'Maintenance Product. Product ID is 1', CAST(N'2019-08-25 03:40:20.000' AS DateTime))
INSERT [dbo].[HistoryStaffs] ([ID], [InfoID], [Des], [Time]) VALUES (41, 17, N'Maintenance Product. Product ID is 2', CAST(N'2019-08-25 03:40:21.000' AS DateTime))
INSERT [dbo].[HistoryStaffs] ([ID], [InfoID], [Des], [Time]) VALUES (42, 17, N'Maintenance Product. Product ID is 3', CAST(N'2019-08-25 03:40:22.000' AS DateTime))
INSERT [dbo].[HistoryStaffs] ([ID], [InfoID], [Des], [Time]) VALUES (43, 17, N'Maintenance Product. Product ID is 4', CAST(N'2019-08-25 03:40:23.000' AS DateTime))
INSERT [dbo].[HistoryStaffs] ([ID], [InfoID], [Des], [Time]) VALUES (44, 17, N'Maintenance Product. Product ID is 5', CAST(N'2019-08-25 03:40:26.000' AS DateTime))
INSERT [dbo].[HistoryStaffs] ([ID], [InfoID], [Des], [Time]) VALUES (45, 17, N'Maintenance Service. Service ID is 1', CAST(N'2019-08-25 03:40:32.000' AS DateTime))
INSERT [dbo].[HistoryStaffs] ([ID], [InfoID], [Des], [Time]) VALUES (46, 17, N'Maintenance Service. Service ID is 2', CAST(N'2019-08-25 03:40:33.000' AS DateTime))
INSERT [dbo].[HistoryStaffs] ([ID], [InfoID], [Des], [Time]) VALUES (47, 17, N'Check out . Bill ID is 16', CAST(N'2019-08-25 03:50:05.000' AS DateTime))
INSERT [dbo].[HistoryStaffs] ([ID], [InfoID], [Des], [Time]) VALUES (48, 17, N'Check out . Bill ID is 18', CAST(N'2019-08-25 04:00:04.000' AS DateTime))
SET IDENTITY_INSERT [dbo].[HistoryStaffs] OFF
SET IDENTITY_INSERT [dbo].[Informations] ON 

INSERT [dbo].[Informations] ([ID], [Name], [Phone], [Email], [Sex], [LevelID], [Coin]) VALUES (1, N'HieuNT', N'0392997510', N'hieu@gmail.com', N'All', 1, 100)
INSERT [dbo].[Informations] ([ID], [Name], [Phone], [Email], [Sex], [LevelID], [Coin]) VALUES (16, N'duong chinh ngu', N'1111111111', N'ngu@gmail.com', N'All', 1, 60)
INSERT [dbo].[Informations] ([ID], [Name], [Phone], [Email], [Sex], [LevelID], [Coin]) VALUES (17, N'Tiennnn', N'12312321312', N'tien@gmail.com', N'All', 6, 0)
SET IDENTITY_INSERT [dbo].[Informations] OFF
SET IDENTITY_INSERT [dbo].[Levels] ON 

INSERT [dbo].[Levels] ([ID], [Name], [Des], [Condition]) VALUES (1, N'Tru Tri', 30, N'Total bill''s price from 5000$ -> ')
INSERT [dbo].[Levels] ([ID], [Name], [Des], [Condition]) VALUES (2, N'Thanh Tang', 25, N'Total bill''s price from 4000$ -> 4999$')
INSERT [dbo].[Levels] ([ID], [Name], [Des], [Condition]) VALUES (3, N'Cao Tang', 20, N'Total bill''s price from 2000$ -> 2999$')
INSERT [dbo].[Levels] ([ID], [Name], [Des], [Condition]) VALUES (4, N'Thay Tu', 15, N'Total bill''s price from 3000$ -> 3999$')
INSERT [dbo].[Levels] ([ID], [Name], [Des], [Condition]) VALUES (5, N'Thien Su', 10, N'Total bill''s price from 1000$ -> 1999$')
INSERT [dbo].[Levels] ([ID], [Name], [Des], [Condition]) VALUES (6, N'Chu Tieu', 5, N'Total bill''s price from 0$ -> 999$')
SET IDENTITY_INSERT [dbo].[Levels] OFF
SET IDENTITY_INSERT [dbo].[Products] ON 

INSERT [dbo].[Products] ([ID], [Name], [Quantity], [Price], [Coin], [Type], [Source], [isDeleted]) VALUES (1, N'do an ngon1', 100, 100, 10, N'food', N'/HieuHomeStay/haha/an/food1.jpg', 0)
INSERT [dbo].[Products] ([ID], [Name], [Quantity], [Price], [Coin], [Type], [Source], [isDeleted]) VALUES (2, N'do an ngon2', 100, 100, 10, N'food', N'/HieuHomeStay/haha/an/food2.jpg', 0)
INSERT [dbo].[Products] ([ID], [Name], [Quantity], [Price], [Coin], [Type], [Source], [isDeleted]) VALUES (3, N'do an ngon3', 100, 100, 10, N'food', N'/HieuHomeStay/haha/an/food3.jpg', 0)
INSERT [dbo].[Products] ([ID], [Name], [Quantity], [Price], [Coin], [Type], [Source], [isDeleted]) VALUES (4, N'do an ngon4', 100, 100, 10, N'food', N'/HieuHomeStay/haha/an/food4.jpg', 0)
INSERT [dbo].[Products] ([ID], [Name], [Quantity], [Price], [Coin], [Type], [Source], [isDeleted]) VALUES (5, N'do an ngon5', 100, 100, 10, N'food', N'/HieuHomeStay/haha/an/food5.jpg', 0)
INSERT [dbo].[Products] ([ID], [Name], [Quantity], [Price], [Coin], [Type], [Source], [isDeleted]) VALUES (6, N'do an ngon6', 100, 100, 10, N'food', N'/HieuHomeStay/haha/an/food6.jpg', 0)
INSERT [dbo].[Products] ([ID], [Name], [Quantity], [Price], [Coin], [Type], [Source], [isDeleted]) VALUES (7, N'do an ngon7', 100, 100, 10, N'food', N'/HieuHomeStay/haha/an/food7.jpg', 0)
INSERT [dbo].[Products] ([ID], [Name], [Quantity], [Price], [Coin], [Type], [Source], [isDeleted]) VALUES (8, N'do an ngon8', 100, 100, 10, N'food', N'/HieuHomeStay/haha/an/food8.jpg', 0)
INSERT [dbo].[Products] ([ID], [Name], [Quantity], [Price], [Coin], [Type], [Source], [isDeleted]) VALUES (9, N'do an ngon9', 100, 100, 10, N'food', N'/HieuHomeStay/haha/an/food9.jpg', 0)
INSERT [dbo].[Products] ([ID], [Name], [Quantity], [Price], [Coin], [Type], [Source], [isDeleted]) VALUES (10, N'do an ngon10', 100, 100, 10, N'food', N'/HieuHomeStay/haha/an/food10.jpg', 0)
INSERT [dbo].[Products] ([ID], [Name], [Quantity], [Price], [Coin], [Type], [Source], [isDeleted]) VALUES (11, N'do an ngon11', 100, 100, 10, N'food', N'/HieuHomeStay/haha/an/food11.jpg', 0)
INSERT [dbo].[Products] ([ID], [Name], [Quantity], [Price], [Coin], [Type], [Source], [isDeleted]) VALUES (12, N'do an ngon12', 100, 100, 10, N'food', N'/HieuHomeStay/haha/an/food12.jpg', 0)
INSERT [dbo].[Products] ([ID], [Name], [Quantity], [Price], [Coin], [Type], [Source], [isDeleted]) VALUES (13, N'do an ngon13', 100, 100, 10, N'food', N'/HieuHomeStay/haha/an/food13.jpg', 0)
INSERT [dbo].[Products] ([ID], [Name], [Quantity], [Price], [Coin], [Type], [Source], [isDeleted]) VALUES (14, N'do an ngon14', 100, 100, 10, N'food', N'/HieuHomeStay/haha/an/food14.jpg', 0)
INSERT [dbo].[Products] ([ID], [Name], [Quantity], [Price], [Coin], [Type], [Source], [isDeleted]) VALUES (15, N'do an ngon15', 100, 100, 10, N'food', N'/HieuHomeStay/haha/an/food15.jpg', 0)
INSERT [dbo].[Products] ([ID], [Name], [Quantity], [Price], [Coin], [Type], [Source], [isDeleted]) VALUES (16, N'do an ngon16', 100, 100, 10, N'food', N'/HieuHomeStay/haha/an/food16.jpg', 0)
INSERT [dbo].[Products] ([ID], [Name], [Quantity], [Price], [Coin], [Type], [Source], [isDeleted]) VALUES (17, N'do an ngon17', 100, 100, 10, N'food', N'/HieuHomeStay/haha/an/food17.jpg', 0)
INSERT [dbo].[Products] ([ID], [Name], [Quantity], [Price], [Coin], [Type], [Source], [isDeleted]) VALUES (18, N'do an ngon18', 100, 100, 10, N'food', N'/HieuHomeStay/haha/an/food18.jpg', 0)
SET IDENTITY_INSERT [dbo].[Products] OFF
SET IDENTITY_INSERT [dbo].[Roles] ON 

INSERT [dbo].[Roles] ([ID], [Name]) VALUES (1, N'admin')
INSERT [dbo].[Roles] ([ID], [Name]) VALUES (3, N'customer')
INSERT [dbo].[Roles] ([ID], [Name]) VALUES (2, N'staff')
SET IDENTITY_INSERT [dbo].[Roles] OFF
SET IDENTITY_INSERT [dbo].[Rooms] ON 

INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (1, N'cau1', N'gan cau chua', 200, 0, N'/HieuHomeStay/haha/noi/cau1.jpg', 0)
INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (2, N'cau2', N'gan cau chua', 200, 0, N'/HieuHomeStay/haha/noi/cau2.jpg', 0)
INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (374, N'cau3', N'gan cau chua', 200, 0, N'/HieuHomeStay/haha/noi/cau3.jpg', 0)
INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (375, N'cau4', N'gan cau chua', 200, 0, N'/HieuHomeStay/haha/noi/cau4.jpg', 0)
INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (376, N'cau5', N'gan cau chua', 200, 0, N'/HieuHomeStay/haha/noi/cau5.jpg', 0)
INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (377, N'cau thang1', N'gan cau thang chua', 100, 0, N'/HieuHomeStay/haha/noi/cauthang1.jpg', 0)
INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (378, N'cau thang2', N'gan cau thang chua', 100, 0, N'/HieuHomeStay/haha/noi/cauthang2.jpg', 0)
INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (379, N'cong1', N'gan cong chua', 1000, 0, N'/HieuHomeStay/haha/noi/cong1.jpg', 0)
INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (380, N'cong2', N'gan cong chua', 1000, 0, N'/HieuHomeStay/haha/noi/cong2.jpg', 0)
INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (381, N'cong3', N'gan cong chua', 1000, 0, N'/HieuHomeStay/haha/noi/cong3.jpg', 0)
INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (382, N'cong4', N'gan cong chua', 1000, 0, N'/HieuHomeStay/haha/noi/cong4.jpg', 0)
INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (383, N'ho1', N'gan ho nuoc', 500, 0, N'/HieuHomeStay/haha/noi/ho1.jpg', 0)
INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (384, N'ho2', N'gan ho nuoc', 500, 0, N'/HieuHomeStay/haha/noi/ho2.jpg', 0)
INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (385, N'ho3', N'gan ho nuoc', 500, 0, N'/HieuHomeStay/haha/noi/ho3.jpg', 0)
INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (386, N'ho4', N'gan ho nuoc', 500, 0, N'/HieuHomeStay/haha/noi/ho4.jpg', 0)
INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (387, N'ho5', N'gan ho nuoc', 500, 0, N'/HieuHomeStay/haha/noi/ho5.jpg', 0)
INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (388, N'ho6', N'gan ho nuoc', 500, 0, N'/HieuHomeStay/haha/noi/ho6.jpg', 0)
INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (389, N'ho7', N'gan ho nuoc', 500, 0, N'/HieuHomeStay/haha/noi/ho7.jpg', 0)
INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (390, N'ho8', N'gan ho nuoc', 500, 0, N'/HieuHomeStay/haha/noi/ho8.jpg', 0)
INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (391, N'ho9', N'gan ho nuoc', 500, 0, N'/HieuHomeStay/haha/noi/ho9.jpg', 0)
INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (392, N'ngoai troi1', N'o ngoai troi', 2000, 0, N'/HieuHomeStay/haha/noi/ngoaitroi1.jpg', 0)
INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (393, N'san chua1', N'gan san chua', 100, 0, N'/HieuHomeStay/haha/noi/sanchua1.jpg', 0)
INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (394, N'san chua2', N'gan san chua', 100, 0, N'/HieuHomeStay/haha/noi/sanchua2.jpg', 0)
INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (395, N'san chua3', N'gan san chua', 100, 0, N'/HieuHomeStay/haha/noi/sanchua3.jpg', 0)
INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (396, N'san chua4', N'gan san chua', 100, 0, N'/HieuHomeStay/haha/noi/sanchua4.jpg', 0)
INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (397, N'san chua5', N'gan san chua', 100, 0, N'/HieuHomeStay/haha/noi/sanchua5.jpg', 0)
INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (398, N'san chua6', N'gan san chua', 100, 0, N'/HieuHomeStay/haha/noi/sanchua6.jpg', 0)
INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (399, N'suoi1', N'gan suoi', 3000, 0, N'/HieuHomeStay/haha/noi/suoi1.jpg', 0)
INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (400, N'suoi2', N'gan suoi', 3000, 0, N'/HieuHomeStay/haha/noi/suoi2.jpg', 0)
INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (401, N'tinh yeu1', N'cau duyen', 5000, 0, N'/HieuHomeStay/haha/noi/tinhyeu1.jpg', 0)
INSERT [dbo].[Rooms] ([ID], [Name], [Des], [Price], [isBooked], [Source], [isDeleted]) VALUES (402, N'tinh yeu2', N'cau duyen', 5000, 0, N'/HieuHomeStay/haha/noi/tinhyeu2.jpg', 0)
SET IDENTITY_INSERT [dbo].[Rooms] OFF
SET IDENTITY_INSERT [dbo].[Services] ON 

INSERT [dbo].[Services] ([ID], [Name], [Price], [Des], [Source], [isDeleted]) VALUES (1, N'Kung Fu', 500, N'vui', N'/HieuHomeStay/haha/vu/1.jpg', 0)
INSERT [dbo].[Services] ([ID], [Name], [Price], [Des], [Source], [isDeleted]) VALUES (2, N'Tam suoi nc nong', 500, N'vui', N'/HieuHomeStay/haha/vu/2.jpg', 0)
INSERT [dbo].[Services] ([ID], [Name], [Price], [Des], [Source], [isDeleted]) VALUES (3, N'Cao Dau', 500, N'vui', N'/HieuHomeStay/haha/vu/3.jpg', 0)
SET IDENTITY_INSERT [dbo].[Services] OFF
/****** Object:  Index [one_account]    Script Date: 25/08/2019 05:14:30 ******/
ALTER TABLE [dbo].[Accounts] ADD  CONSTRAINT [one_account] UNIQUE NONCLUSTERED 
(
	[InfoID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [one_levelName]    Script Date: 25/08/2019 05:14:30 ******/
ALTER TABLE [dbo].[Levels] ADD  CONSTRAINT [one_levelName] UNIQUE NONCLUSTERED 
(
	[Name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [one_roleName]    Script Date: 25/08/2019 05:14:30 ******/
ALTER TABLE [dbo].[Roles] ADD  CONSTRAINT [one_roleName] UNIQUE NONCLUSTERED 
(
	[Name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Accounts]  WITH CHECK ADD  CONSTRAINT [FK_Accounts_Informations] FOREIGN KEY([InfoID])
REFERENCES [dbo].[Informations] ([ID])
GO
ALTER TABLE [dbo].[Accounts] CHECK CONSTRAINT [FK_Accounts_Informations]
GO
ALTER TABLE [dbo].[Accounts]  WITH CHECK ADD  CONSTRAINT [FK_Accounts_Roles] FOREIGN KEY([RoleID])
REFERENCES [dbo].[Roles] ([ID])
GO
ALTER TABLE [dbo].[Accounts] CHECK CONSTRAINT [FK_Accounts_Roles]
GO
ALTER TABLE [dbo].[Bills]  WITH CHECK ADD  CONSTRAINT [FK_Bills_Informations] FOREIGN KEY([InfoID])
REFERENCES [dbo].[Informations] ([ID])
GO
ALTER TABLE [dbo].[Bills] CHECK CONSTRAINT [FK_Bills_Informations]
GO
ALTER TABLE [dbo].[Bills]  WITH CHECK ADD  CONSTRAINT [FK_Bills_Informations1] FOREIGN KEY([StaffID])
REFERENCES [dbo].[Informations] ([ID])
GO
ALTER TABLE [dbo].[Bills] CHECK CONSTRAINT [FK_Bills_Informations1]
GO
ALTER TABLE [dbo].[HistoryStaffs]  WITH CHECK ADD  CONSTRAINT [FK_HistoryStaffs_Informations] FOREIGN KEY([InfoID])
REFERENCES [dbo].[Informations] ([ID])
GO
ALTER TABLE [dbo].[HistoryStaffs] CHECK CONSTRAINT [FK_HistoryStaffs_Informations]
GO
ALTER TABLE [dbo].[Informations]  WITH CHECK ADD  CONSTRAINT [FK_Informations_Levels] FOREIGN KEY([LevelID])
REFERENCES [dbo].[Levels] ([ID])
GO
ALTER TABLE [dbo].[Informations] CHECK CONSTRAINT [FK_Informations_Levels]
GO
ALTER TABLE [dbo].[ProductCoinDetails]  WITH CHECK ADD  CONSTRAINT [FK_ProductCoinDetails_BillCoins] FOREIGN KEY([BillCoinID])
REFERENCES [dbo].[BillCoins] ([ID])
GO
ALTER TABLE [dbo].[ProductCoinDetails] CHECK CONSTRAINT [FK_ProductCoinDetails_BillCoins]
GO
ALTER TABLE [dbo].[ProductCoinDetails]  WITH CHECK ADD  CONSTRAINT [FK_ProductCoinDetails_Products] FOREIGN KEY([ProductID])
REFERENCES [dbo].[Products] ([ID])
GO
ALTER TABLE [dbo].[ProductCoinDetails] CHECK CONSTRAINT [FK_ProductCoinDetails_Products]
GO
ALTER TABLE [dbo].[ProductDetails]  WITH CHECK ADD  CONSTRAINT [FK_ProductDetails_Bills] FOREIGN KEY([BillID])
REFERENCES [dbo].[Bills] ([ID])
GO
ALTER TABLE [dbo].[ProductDetails] CHECK CONSTRAINT [FK_ProductDetails_Bills]
GO
ALTER TABLE [dbo].[ProductDetails]  WITH CHECK ADD  CONSTRAINT [FK_ProductDetails_Products] FOREIGN KEY([ProID])
REFERENCES [dbo].[Products] ([ID])
GO
ALTER TABLE [dbo].[ProductDetails] CHECK CONSTRAINT [FK_ProductDetails_Products]
GO
ALTER TABLE [dbo].[RoomDetails]  WITH CHECK ADD  CONSTRAINT [FK_RoomDetails_Bills] FOREIGN KEY([BillID])
REFERENCES [dbo].[Bills] ([ID])
GO
ALTER TABLE [dbo].[RoomDetails] CHECK CONSTRAINT [FK_RoomDetails_Bills]
GO
ALTER TABLE [dbo].[RoomDetails]  WITH CHECK ADD  CONSTRAINT [FK_RoomDetails_Rooms] FOREIGN KEY([RoomID])
REFERENCES [dbo].[Rooms] ([ID])
GO
ALTER TABLE [dbo].[RoomDetails] CHECK CONSTRAINT [FK_RoomDetails_Rooms]
GO
ALTER TABLE [dbo].[ServiceDetails]  WITH CHECK ADD  CONSTRAINT [FK_ServiceDetails_Bills] FOREIGN KEY([BillID])
REFERENCES [dbo].[Bills] ([ID])
GO
ALTER TABLE [dbo].[ServiceDetails] CHECK CONSTRAINT [FK_ServiceDetails_Bills]
GO
ALTER TABLE [dbo].[ServiceDetails]  WITH CHECK ADD  CONSTRAINT [FK_ServiceDetails_Services] FOREIGN KEY([SerID])
REFERENCES [dbo].[Services] ([ID])
GO
ALTER TABLE [dbo].[ServiceDetails] CHECK CONSTRAINT [FK_ServiceDetails_Services]
GO
USE [master]
GO
ALTER DATABASE [HieuHomeStay] SET  READ_WRITE 
GO
