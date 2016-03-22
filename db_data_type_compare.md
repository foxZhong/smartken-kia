# Introduction #

ORACLE与SQLSERVER、MYSQL的数据类型对照表

# Details #

|Oracle 数据类型|SQL Server 数据类型|Mysql数据类型|是否备用|
|:----------|:--------------|:--------|:---|
|BFILE      |VARBINARY(MAX) |         |是   |
|BLOB       |VARBINARY(MAX) |BLOB, LONGBLOB, MEDIUMBLOB|是   |
|CHAR([1-2000])|CHAR([1-2000]) |CHAR     |是   |
|CLOB       |VARCHAR(MAX)   |TEXT, LONGTEXT, MEDIUMTEXT|是   |
|DATE       |DATETIME       |DATE,DATETIME, TIME, TIMESTAMP|是   |
|FLOAT      |FLOAT          |REAL     |否   |
|FLOAT([1-53])|FLOAT([1-53])  |DECIMAL,DOUBLE,DOUBLE PRECISION|否   |
|FLOAT([54-126])|FLOAT          |DECIMAL, DOUBLE, DOUBLE PRECISION|否   |
|INT        |NUMERIC(38)    |         |是   |
|INTERVAL   |DATETIME       |         |是   |
|LONG       |VARCHAR(MAX)   |         |是   |
|LONG RAW   |IMAGE          |         |是   |
|NCHAR([1-1000])|NCHAR([1-1000]) |         |否   |
|NCLOB      |NVARCHAR(MAX)  |         |是   |
|NUMBER     |FLOAT          |INT, INTEGER, NUMERIC, YEAR, MEDIUMINT|是   |
|NUMBER([1-38])|NUMERIC([1-38])|SMALLINT, TINYINT, BIGINT|否   |
|NUMBER([0-38],[1-38])|NUMERIC([0-38],[1-38])|         |是   |
|NVARCHAR2([1-2000])|NVARCHAR([1-2000])|SET, VARCHAR, ENUM|否   |
|RAW([1-2000])|VARBINARY([1-2000])|BLOB,BIT, TINYBLOB, LONGTEXT, LONGBLOB, MEDIUMBLOB, MEDIUMTEXT|否   |
|REAL       |FLOAT          |         |否   |
|ROWID      |CHAR(18)       |         |否   |
|TIMESTAMP  |DATETIME       |         |是   |
|UROWID     |CHAR(18)       |         |否   |
|VARCHAR2([1-4000])|VARCHAR([1-4000])|TEXT, TINYTEXT|是   |


# 1．Oracle数据库的各种数据类型 #

## CHAR 定长的字符型数据，长度<=2000字节 ##

## VARCHAR2 变长的字符型数据，长度<=4000字节 ##

## NCHAR 用来存储Unicode字符集的定长字符型数据，长度<=1000字节 ##

## NVARCHAR2 Unicode字符集的变长字符型数据，长度<=1000字节 ##

## NUMBER 整型或者浮点型数值 ##

## DATE 日期数据 ##

## LONG 2GB的变长字符数据 ##

## RAW 用来存储非结构化数据的变长字符数据，长度<=2000字节 ##

## LONG RAW 用来存储非结构化数据的变长字符数据，长度<=2GB ##

## ROWID 用来存储表中列的物理地址的二进制数据，占用固定的10个字节 ##

## BLOB 4GB的非结构化的二进制数据 ##

## CLOB 4GB的字符数据 ##

## NCLOB 4GB的Unicode字符数据 ##

## BFILE 把非结构化的二进制数据存储在数据库以外的操作系统文件中 ##

## UROWID 表示任何类型列地址的二进制数据 ##

## FLOAT 浮点数 ##

# 2．MySQL数据库的各种数据类型 #

## CHAR (M) CHAR数据类型用于表示M长度的字符串。 ##

## VARCHAR (M) VARCHAR可以保存可变长度的字符串, VARCHAR数据类型所支持的最大长度也是255个字符。 ##

## INT (M) [Unsigned](Unsigned.md) INT数据类型用于保存从- 2147483647 到2147483648范围之内的任意整数数据。如果用户使用Unsigned选项，则有效数据范围调整为0-4294967295。 ##

## FLOAT [(M,D)] FLOAT数据类型用于表示数值较小的浮点数据，可以提供更加准确的数据精度。其中，M代表浮点数据的长度（即小数点左右数据长度的总和），D表示浮点数据位于小数点右边的数值位数。 ##

## DATE DATE数据类型用于保存日期数据，默认格式为YYYY-MM-DD。 ##

## TEXT / BLOB TEXT和BLOB数据类型可以用来保存255 到65535个字符，TEXT不区分大小写，而BLOB对字符的大小写敏感。 ##

## SET SET数据类型是多个数据值的组合，任何部分或全部数据值都是该数据类型的有效数据。SET数据类型最大可以包含64个指定数据值。 ##

## ENUM ENUM数据类型和SET基本相同，唯一的区别在于ENUM只允许选择一个有效数据值。 ##

# 3． MS SQLServer数据库的各种数据类型 #

## bit 整型bit 数据类型是整型，其值只能是0、1或空值。 ##

## int 整型int 数据类型可以存储从- 231(-2147483648)到231 (2147483 647)之间的整数。这种数据类型在数据库里占用4个字节 ##

## smallint 整型smallint 数据类型可以存储从-215(-32768)到215(32767)之间的整数。这种数据类型在数据库里占用2字节空间 ##

## tinyint 整型tinyint 数据类型能存储从0到255 之间的整数。这种数据类型在数据库中占用1 个字节numeric 精确数值型numeric数据类型与decimal型相同 ##

## decimal 精确数值型decimal 数据类型能用来存储从-1038-1到1038-1的固定精度和范围的数值型数据。使用这种数据类型时，必须指定范围和精度。范围是小数点左右所能存储的数字的总位数。精度是小数点右边存储的数字的位数 ##

## money 货币型money 数据类型用来表示钱和货币值。这种数据类型能存储从-9220亿到9220 亿之间的数据，精确到货币单位的万分之一 ##

## smallmoney 货币型smallmoney 数据类型用来表示钱和货币值。这种数据类型能存储从 -214748.3648 到214748.3647 之间的数据，精确到货币单位的万分之一 ##

## float 近似数值型float 数据类型是一种近似数值类型，供浮点数使用。说浮点数是近似的，是因为在其范围内不是所有的数都能精确表示。浮点数可以是从-1.79E+308到1.79E+308 之间的任意数 ##

## real 近似数值型real 数据类型像浮点数一样，是近似数值类型。它可以表示数在-3.40E+38 到3.40E+38之间的浮点数 ##

## datetime 日期时间型datetime数据类型用来表示日期和时间。这种数据类型存储从1753年1 月1日到9999年12月31日间所有的日期和时间数据， 精确到三百分之一秒或3.33 毫秒 ##

## Smalldatetime 日期时间型smalldatetime 数据类型用来表示从1900年1月1日到2079年6月6日间的日期和时间，精确到一分钟 ##

## cursor 特殊数据型cursor 数据类型是一种特殊的数据类型，它包含一个对游标的引用。这种数据类型用在存储过程中，而且创建表时不能用 ##

## timestamp 特殊数据型timestamp 数据类型是一种特殊的数据类型，用来创建一个数据库范围内的唯一数码。 一个表中只能有一个timestamp列。每次插入或修改一行时，timestamp 列的值都会改变。尽管它的名字中有"time"， 但timestamp列不是人们可识别的日期。在一个数据库里，timestamp值是唯一的 ##

## Uniqueidentifier 特殊数据型Uniqueidentifier数据类型用来存储一个全局唯一标识符，即GUID。GUID 确实是全局唯一的。这个数几乎没有机会在另一个系统中被重建。可以使用NEWID函数或转换一个字符串为唯一标识符来初始化具有唯一标识符的列 ##

## char 字符型char数据类型用来存储指定长度的定长非统一编码型的数据。当定义一列为此类型时，你必须指定列长。当你总能知道要存储的数据的长度时，此数据类型很有用。例如，当你按邮政编码加4个字符格式来存储数据时，你知道总要用到10个字符。 此数据类型的列宽最大为8000个字符 ##

## varchar 字符型varchar数据类型，同char类型一样，用来存储非统一编码型字符数据。与char 型不一样，此数据类型为变长。当定义一列为该数据类型时，你要指定该列的最大长度。 它与char数据类型最大的区别是，存储的长度不是列长，而是数据的长度 ##

# text 字符型text 数据类型用来存储大量的非统一编码型字符数据。这种数据类型最多可以有231-1或20亿个字符 #

## nchar 统一编码字符型nchar 数据类型用来存储定长统一编码字符型数据。统一编码用双字节结构来存储每个字符，而不是用单字节(普通文本中的情况)。它允许大量的扩展字符。此数据类型能存储4000种字符，使用的字节空间上增加了一倍 ##

## nvarchar 统一编码字符型nvarchar 数据类型用作变长的统一编码字符型数据。此数据类型能存储4000种字符，使用的字节空间增加了一倍 ##

## ntext 统一编码字符型ntext 数据类型用来存储大量的统一编码字符型数据。这种数据类型能存储230 -1或将近10亿个字符，且使用的字节空间增加了一倍 ##

## binary 二进制数据类型binary数据类型用来存储可达8000 字节长的定长的二进制数据。当输入表的内容接近相同的长度时，你应该使用这种数据类型 ##

## varbinary 二进制数据类型varbinary 数据类型用来存储可达8000 字节长的变长的二进制数据。当输入表的内容大小可变时，你应该使用这种数据类型 ##

## image 二进制数据类型image 数据类型用来存储变长的二进制数据，最大可达231-1或大约20亿字节 ##