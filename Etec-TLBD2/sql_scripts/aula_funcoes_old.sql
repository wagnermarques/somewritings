/*
FUN��ES
*/

/*
CHARINDEX - Pesquisa uma express�o para outra e retorna sua posi��o inicial, se for localizada.
Documenta��o em: https://docs.microsoft.com/pt-br/sql/t-sql/functions/charindex-transact-sql

Exemplo:
*/
DECLARE @document varchar(64);  
SELECT @document = 'Reflectors are vital safety' + ' components of your bicycle.';  
SELECT CHARINDEX('bicycle' ,  @document);  
GO  



/*
CONCAT - Retorna uma cadeia de caracteres que � o resultado da concatena��o de dois ou mais valores.
Documenta��o em: https://docs.microsoft.com/pt-br/sql/t-sql/functions/concat-transact-sql

Exemplo:
*/
SELECT CONCAT ( 'Happy ', 'Birthday ', 11, '/', '25' ) AS Result;  



/*
LTRIM - Retorna uma express�o de caractere depois de remover espa�os em branco � esquerda.
Documenta��o em: https://docs.microsoft.com/pt-br/sql/t-sql/functions/ltrim-transact-sql

Exemplo:
*/
SELECT LTRIM('     Five spaces are at the beginning of this string.') FROM sys.databases; 



/*
REPLACE - Substitui todas as ocorr�ncias de um valor da cadeia de caracteres especificado por outro valor de cadeia de caracteres.
Documenta��o em: https://docs.microsoft.com/pt-br/sql/t-sql/functions/replace-transact-sql

Exemplo:
*/
SELECT REPLACE('abcdefghicde','cde','xxx');  
GO  



/*
STR - Retorna dados de caractere convertidos de dados num�ricos.
Documenta��o em: https://docs.microsoft.com/pt-br/sql/t-sql/functions/str-transact-sql

Exemplo:
*/
SELECT STR(123.45, 6, 1);  
GO  



/*
CEILING - Retorna o menor inteiro maior que ou igual a express�o num�rica especificada.
Documenta��o em: https://docs.microsoft.com/pt-br/sql/t-sql/functions/ceiling-transact-sql

Exemplo:
*/
SELECT CEILING($123.45), CEILING($-123.45), CEILING($0.0);  
GO  



/*
FLOOR - Retorna o maior inteiro menor ou igual � express�o num�rica especificada.
Documenta��o em: https://docs.microsoft.com/pt-br/sql/t-sql/functions/floor-transact-sql

Exemplo:
*/
SELECT FLOOR(123.45), FLOOR(-123.45), FLOOR($123.45);  
GO



/*
SUM - Retorna o maior inteiro menor ou igual � express�o num�rica especificada.
Documenta��o em: https://docs.microsoft.com/pt-br/sql/t-sql/functions/sum-transact-sql

Exemplo:
*/
SELECT Color, SUM(ListPrice), SUM(StandardCost)  
FROM Production.Product  
WHERE Color IS NOT NULL   
    AND ListPrice != 0.00   
    AND Name LIKE 'Mountain%'  
GROUP BY Color  
ORDER BY Color;  
GO  



/*
AVG - Retorna o maior inteiro menor ou igual � express�o num�rica especificada.
Documenta��o em: https://docs.microsoft.com/pt-br/sql/t-sql/functions/avg-transact-sql

Exemplo:
*/

SELECT AVG(ListPrice)  
FROM Production.Product;



/*
MAX - Retorna o maior inteiro menor ou igual � express�o num�rica especificada.
Documenta��o em: https://docs.microsoft.com/pt-br/sql/t-sql/functions/max-transact-sql

Exemplo:
*/

SELECT MAX(TaxRate)  
FROM Sales.SalesTaxRate;  
GO  



/*
MIN - Retorna o maior inteiro menor ou igual � express�o num�rica especificada.
Documenta��o em: https://docs.microsoft.com/pt-br/sql/t-sql/functions/min-transact-sql

Exemplo:
*/

SELECT MIN(TaxRate)  
FROM Sales.SalesTaxRate;  
GO 



/*
COUNT - Retorna o maior inteiro menor ou igual � express�o num�rica especificada.
Documenta��o em: https://docs.microsoft.com/pt-br/sql/t-sql/functions/count-transact-sql

Exemplo:
*/

SELECT COUNT(DISTINCT Title)  
FROM HumanResources.Employee;  
GO  




/*

Explica��o da atividade:

- Aplicar as fun��es no banco da aula passada "lojainfo";
- Observe o exemplo:

select * from dbo.tb_vendas_itens;
GO

SELECT MAX(total_item)  
FROM dbo.tb_vendas_itens;  
GO  

SELECT MIN(total_item)  
FROM dbo.tb_vendas_itens;  
GO  

SELECT ROUND(CAST(AVG(total_item) AS decimal (8,2)),2)  
FROM dbo.tb_vendas_itens;  
GO  


SELECT (AVG(total_item))  
FROM dbo.tb_vendas_itens;  
GO  







