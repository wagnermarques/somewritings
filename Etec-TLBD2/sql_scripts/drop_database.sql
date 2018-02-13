use master
go

ALTER DATABASE lojainfo SET SINGLE_USER WITH ROLLBACK IMMEDIATE
GO

drop database lojainfo
go
