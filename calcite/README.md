# Apache Calcite Example


>Apache Calcite is a dynamic data management framework.
>
>It contains many of the pieces that comprise a typical database management system, but omits some key functions: storage of data, algorithms to process data, and a repository for storing metadata.
>
>Calcite intentionally stays out of the business of storing and processing data. As we shall see, this makes it an excellent choice for mediating between applications and one or more data storage locations and data processing engines. It is also a perfect foundation for building a database: just add data.
> 
>> [Calcite documentation](/https://calcite.apache.org/docs/)

This example is separated on three smaller examples of calcite usage to help understand the framework. It's like 3 steps to follow in order to fully understand the example.

## Basic

It shows how to create a connection to calcite and manually register tables in the schema.
Then make a SQL request and get the result in a `ResultSet` object

## Simple

The second step show hows to have a more complex table representation in the code base with a custom iterator to read data from the table.


## Loader

The last step shows how to fully use calcite to load our tables and schema.