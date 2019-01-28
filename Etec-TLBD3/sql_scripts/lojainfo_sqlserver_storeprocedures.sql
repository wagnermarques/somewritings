use lojainfo;
GO

IF OBJECT_ID ('dbo.proc_exemplo') IS NOT NULL
    DROP PROC dbo.select_produtos_com_algum_desconto;
GO           

CREATE PROCEDURE dbo.select_produtos_com_algum_desconto
AS
BEGIN
select tb_produtos

