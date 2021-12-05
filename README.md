#Structure
An index is the highest form of storage. A single index contains multiple documents. A document is a set of key-value pairs.

An easy way to understand this organisation system is by corelating it to the way SQL organises data.
|SQL|NextLevelDB|
|---|-----------|
|Database|Index|
|Table|Document|
|Row|Key-value pair|

#Basic features
* Provide CRUD operations using keywords CREATE, VIEW, UPDATE, DELETE
* End every command with a semicolon so that it's easy for us to process it
* (Idea) Provide feature to dump a document with EXPORT and import it with... (you guessed it right) IMPORT
* (Idea) Enforce specific data types for key and value (like SQL field data types)

#Implementation
* __Storage__: _Maps_. Literally everything can be done with maps, and it'll save us a ton of work.
    * Index: map(index_name, *documents[])
    * Document: map(document_name, *data[])
    * Data: map(key, value)
* __CLI__: Let's just read the user input as a string, split it at spaces, and handle it based on the identifiers.
    * Every command will be in the following structure: `OPERATION IDENTIFIER [VALUES]`. For example,
        * `create index nextleveldb`
        * `create document test`
        * `create pair "foo" "bar"`
        * `delete pair "foo"`
        * `delete index nextleveldb`
    * In case of the last command, we should probably display a warning saying "Index contains documents, continue with deletion? (y/n)"
* __Classes__:
    * NextLevelDB (the main class)
    * Index
    * Document
    * Pair
    * Cli
