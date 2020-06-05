use master;

drop database lojainfo
go

CREATE DATABASE lojainfo;
-- Exec sp_databases;
Go


use lojainfo;
-- Exec sp_tables

:r create_tables.sql
-- Exec sp_tables

:r create_tables_tests.sql


/*
https://technet.microsoft.com/pt-br/library/ms187953(v=sql.105).aspx
*/

PRINT N'########BASICAO DE VARIAVEIS'

-- Declarando uma variavel
DECLARE @MyCounter int;

-- Inicializando uma variavel
SET @MyCounter = 0;
SELECT @MyCounter
SET @MyCounter = 1;
SELECT @MyCounter
PRINT N'==================================='
-- A variavel pode ser referenciado durante  a execucao do lote


/*
FUNÇÕES
*/

/*
CHARINDEX - Pesquisa uma expressão para outra e retorna sua posição inicial, se for localizada.
Documentação em: https://docs.microsoft.com/pt-br/sql/t-sql/functions/charindex-transact-sql

Exemplo:
CHARINDEX ( expressionToFind , expressionToSearch [ , start_location ] )   
*/

DECLARE @document varchar(64);  
SELECT @document = 'Reflectors are vital safety' + ' components of your bicycle.';

PRINT N'########FUNCAO CHARINDEX'
PRINT N'CHARINDEX: bicicle'
SELECT CHARINDEX('bicycle' ,  @document);

PRINT N'CHARINDEX: are'
SELECT CHARINDEX('are' ,  @document);

PRINT N'CHARINDEX: ARE'
SELECT CHARINDEX('ARE' ,  @document);

PRINT N'CHARINDEX: Ref'
SELECT CHARINDEX('Ref' ,  @document);

PRINT N'CHARINDEX: ect'
SELECT CHARINDEX('ect' ,  @document);
PRINT N'================================================================='
GO  



/*
CONCAT - Retorna uma cadeia de caracteres que é o resultado da concatenação de dois ou mais valores.
Documentação em: https://docs.microsoft.com/pt-br/sql/t-sql/functions/concat-transact-sql

Exemplo:
*/
PRINT N'########FUNCAO CONCAT'
SELECT CONCAT ( 'Happy ', 'Birthday ', 11, '/', '25' ) AS Result;  
PRINT N'================================================================='



PRINT N'########FUNCAO TRIM'
/*
LTRIM - Retorna uma expressão de caractere depois de remover espaços em branco à esquerda.
Documentação em: https://docs.microsoft.com/pt-br/sql/t-sql/functions/ltrim-transact-sql

Exemplo:
*/
SELECT LTRIM('     Five spaces are at the beginning of this string.') FROM sys.databases; 
PRINT N'================================================================='


PRINT N'########FUNCAO REPLACE'
/*
REPLACE - Substitui todas as ocorrências de um valor da cadeia de caracteres especificado por outro valor de cadeia de caracteres.
Documentação em: https://docs.microsoft.com/pt-br/sql/t-sql/functions/replace-transact-sql

Exemplo:
*/
SELECT REPLACE('abcdefghicde','cde','xxx');
PRINT N'================================================================='
GO  


PRINT N'########FUNCAO STRING'
/*
STR - Retorna dados de caractere convertidos de dados numéricos.
Documentação em: https://docs.microsoft.com/pt-br/sql/t-sql/functions/str-transact-sql

Exemplo:
*/
SELECT STR(123.45, 6, 1);
PRINT N'================================================================='
GO  



PRINT N'########FUNCAO CEILING'
/*
CEILING - Retorna o menor inteiro maior que ou igual a expressão numérica especificada.
Documentação em: https://docs.microsoft.com/pt-br/sql/t-sql/functions/ceiling-transact-sql

Exemplo:
*/
SELECT CEILING($123.45), CEILING($-123.45), CEILING($0.0);
PRINT N'================================================================='
GO  


PRINT N'########FUNCAO FLOOR'
/*
FLOOR - Retorna o maior inteiro menor ou igual à expressão numérica especificada.
Documentação em: https://docs.microsoft.com/pt-br/sql/t-sql/functions/floor-transact-sql

Exemplo:
*/
SELECT FLOOR(123.45), FLOOR(-123.45), FLOOR($123.45);
PRINT N'================================================================='
GO


PRINT N'########FUNCOES DATA'
DECLARE @DTA DATETIME;
SELECT  @DTA = GETDATE()

PRINT N'########FUNCOES DATAADD'
PRINT N'DATEADD (datepart, number, date)'
PRINT N'Adiciona 30 dias a data @Dta'
SELECT @DTA as '@DTA e getdate()'

DECLARE @DTAMAIS30 DATE;
SELECT @DTAMAIS30 = DATEADD(DAY, 30, GETDATE())
SELECT @DTAMAIS30 AS 'Data + 30 Dias'

PRINT N'########FUNCOES DATADIFF'
PRINT N'DATEDIFF (datepart, startdate, enddate)'
PRINT N'Retorna um inteiro que pode representar anos, meses, horas, minutos, segundos ou milisegundos'
DECLARE @QTOS_DIAS_DESSE_ANO int;
SELECT @QTOS_DIAS_DESSE_ANO = DATEDIFF(DAY, '01/01/2018', GETDATE())
SELECT @QTOS_DIAS_DESSE_ANO AS 'N de dias desse ano'


PRINT N''

PRINT N'########FUNCOES DATEPART (datepart, date)'
DECLARE @DATE_PART_MES INT;
DECLARE @DATE_PART_ANO INT;
DECLARE @DATE_PART_DIA INT;
DECLARE @DATE_PART_HORA INT;
DECLARE @DATE_PART_MIN INT;
DECLARE @DATE_PART_SEG INT;

SELECT @DATE_PART_ANO = DATEPART(YEAR, @DTA)
SELECT @DATE_PART_MES = DATEPART(MONTH, @DTA)
SELECT @DATE_PART_DIA = DATEPART(DAY, @DTA)
SELECT @DATE_PART_HORA = DATEPART(hour, @DTA)
SELECT @DATE_PART_MIN = DATEPART(minute, @DTA)
SELECT @DATE_PART_SEG = DATEPART(second, @DTA)

SELECT @DATE_PART_ANO AS 'Parte ANO de getdate()'
SELECT @DATE_PART_MES AS 'Parte MES de getdate()'
SELECT @DATE_PART_DIA AS 'Parte DIA de getdate()'
SELECT @DATE_PART_HORA AS 'Parte HORA de getdate()'
SELECT @DATE_PART_MIN AS 'Parte MIN de getdate()'
SELECT @DATE_PART_SEG AS 'Parte SEG de getdate()'


PRINT N'######## CRIANDO FUNCAO'
PRINT N'funcao escalar soma 1+2 e mostra o resultado'
GO -- ESSE GO é pra gente nao tomar o erro:  'CREATE FUNCTION' must be the first statement in a query batch.
CREATE FUNCTION SOMA(@a INT , @b INT) RETURNS INT
       AS
       BEGIN
         RETURN @a+@b
       END 
Go

SELECT dbo.SOMA(1,2)

Go
CREATE FUNCTION OBTER_CLIENTES_QUE_NAO_COMPRARAM_NADA()
RETURNS (SELECT *
