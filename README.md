# Structure
An index is the highest form of storage. A single index contains multiple documents. A document is a set of key-value pairs.

An easy way to understand this organisation system is by corelating it to the way SQL organises data.
|SQL|NextLevelDB|
|---|-----------|
|Database|Index|
|Table|Document|
|Row|Key-value pair|

# Basic features
* Provide CRUD operations using keywords CREATE, LIST, UPDATE, DELETE
* (Idea) Provide feature to dump a document with EXPORT and import it with... (you guessed it right) IMPORT
* (Idea) Enforce specific data types for key and value (like SQL field data types)

# Implementation
* __Storage__: _Maps_. Literally everything can be done with maps.
    * DB contains map(indexName, Index)
    * Index contains map(documentName, Document)
    * Document contains map(key, value)
* __CLI__: We read the user input as a string, split it at spaces, and handle it based on the identifiers.
    * Every command is in the following syntax: `OPERATION IDENTIFIER [VALUES]`. For example,
        * `create index nextleveldb`
        * `create doc test`
        * `create pair foo bar`
        * `get pair foo`
        * `delete pair foo`
        * `delete index nextleveldb`
    * In case of the last command, we display a warning saying "Index contains documents, continue with deletion? (y/n)"

# Technical Specification
* __Classes__:
    * NextLevelDB (the database instance)
        * listIndexes
        * getIndex
        * createIndex
        * deleteIndex
    * Index
        * listDocuments
        * getDocument
        * createDocument
        * deleteDocument
    * Document
        * listPairs
        * getPair
        * createPair
        * updatePair
        * deletePair
    * Parser
        * parse
        * indexHandler
        * documentHandler
        * pairHandler
    * Cli
        * run
        * printLogo
    * Run
        * main

# Contribution
* Create a separate branch for every feature, and once it's working, send a PR. If you commit to main, I'll personally stab you (especially if something breaks).
* Maintain neat, clean, readable code. Use sensible variable and function names, and write comments for the confusing parts.
* Use __1 tabspace__ only for indentation. Please don't use spaces, it just makes the coding experience messy.
* See [this](https://www.conventionalcommits.org/en/v1.0.0/) for how to write readable commit messages.
* Don't commit any generated files, compiled .class files or other temporary stuff. If you have something that should not be committed, add it to the .gitignore file.
