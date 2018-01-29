//Improve the code
class TokenStream {
    List<String> v; //a list of tokens parsed from br.
    int index; //index of the current token in v.
    BufferedReader br; //read the chars from here to parse the tokens.
    int currentChar; //previous char read from br.
    //read the chars from the reader and parse the tokens.
    TokenStream(Reader read) {
        br = new BufferedReader(read);
        takeChar();
        v = parseFile();
        index=0;
    }
    //read the chars from br, parse the tokens and store them into an List
    List<String> parseFile() {
        List<String> v; //accumulate the tokens that have been parsed.
        ...
        return v;
    }
    ...
}