class TokenStream {
    List<String> parsedTokenList;
    int currentTokenIdxInList;
    BufferedReader charInputSourceForParsing;
    int previousCharReadFromSource;
    TokenStream(Reader reader) {
        charInputSourceForParsing = new BufferedReader(reader);
        takeChar();
        parsedTokenList = parseTokensFromInputSource();
        currentTokenIdxInList = 0;
    }
    List<String> parseTokensFromInputSource() {
        List<String> tokensParsedSoFar;
        ...
        return tokensParsedSoFar;
    }
    ...
}
