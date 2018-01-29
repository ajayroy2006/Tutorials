//improve code
class ReportCatalogueIndexCommandParser {
    final String NO_GROUPING = "orgNoGrouping";
    static final int ORG_CATALOG = 0;
    static final int PART_CATALOG = 1;
    //.... other codes
    int getGroupingType(String grouping) {
        if (grouping.equals(NO_GROUPING)) {
            return ORG_CATALOG;
        } else if (grouping.equals("orgGroupByCountry")) {
            return ORG_CATALOG;
        } else if (grouping.equals("orgGroupByTypeOfOrgName")) {
            return ORG_CATALOG;
        } else if (grouping.equals("part")) {
            return PART_CATALOG;
        } else if {.... // many other if statements
        } else
            throw new IllegalArgumentException("Invalid grouping!");
	}
}
