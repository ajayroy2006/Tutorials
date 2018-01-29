class ReportCatalogueIndexCommandParser {
    static final int ORG_CATALOG = 0;
    static final int PART_CATALOG = 1;
    private static HashMap catalogCodes<String, Integer>;
    static {
        catalogCodes = new HashMap<String,Integer>;
        catalogCodes.put("orgNoGrouping", ORG_CATALOG);
        catalogCodes.put("orgGroupByCountry", ORG_CATALOG);
        catalogCodes.put("orgGroupByTypeOfOrgName", ORG_CATALOG);
        catalogCodes.put("part", PART_CATALOG);
        ...
    }
    int getGroupingType(String grouping) {
        Integer groupingType = catalogCodes.get(grouping);
        if (groupingType == null)
            throw new IllegalArgumentException("Invalid grouping!");
        return groupingType;
    }
}
