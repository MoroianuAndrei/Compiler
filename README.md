# 🖥️ MiniCompiler

## 📌 Overview  
MiniCompiler is a **C#-based compiler** that performs **lexical, syntactic, and semantic analysis** using **ANTLR**. It processes source code, identifies errors, and generates tokens and structured data representations.  

## 🛠️ Features  
- **Lexical Analysis**: Tokenizes input code and identifies valid syntax elements.  
- **Syntactic Analysis**: Parses code using **ANTLR-generated grammar** (`BasicLanguage.g4`).  
- **Semantic Analysis**: Checks for type mismatches, undeclared variables, and function errors.  
- **Control Structures Support**: Implements **if, while, and for** statements.  
- **Function Handling**: Supports function declarations and type validation.  
- **Error Reporting**: Saves lexical, syntactic, and semantic errors in `errors.txt`.  
- **AST Processing**: Uses a **visitor pattern** to traverse and analyze the parse tree.  
- **File-Based Input & Output**: Reads source code from `program.txt` and stores results in an output directory.  

## 🚀 How It Works  
1. Reads the source code from `program.txt`.  
2. Tokenizes the input and checks for lexical errors.  
3. Parses the code to construct an **Abstract Syntax Tree (AST)**.  
4. Performs **semantic analysis** to validate variables and function types.  
5. Outputs structured data to `variables.txt`, `functions.txt`, `control_structures.txt`, and `errors.txt`.  

## 🔧 Technologies Used  
- **C#** for compiler implementation.  
- **ANTLR** for lexical and syntactic parsing.  
