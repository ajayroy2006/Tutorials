class SurveyDataType {
	String baseFileName;
	boolean hideDataFile;
	SurveyDataType(String baseFileName, boolean hideDataFile) {
		this.baseFileName = baseFileName;
		this.hideDataFile = hideDataFile;
	}
	String getSavePath() {
		return "c:/application/data/"+baseFileName+".dat";
	}
	static SurveyDataType rawDataType = new SurveyDataType(
	        "raw", true);
	static SurveyDataType cleanedUpDataType = new SurveyDataType(
	        "cleanedUp", true);
	static SurveyDataType processedDataType = new SurveyDataType(
	        "processed", true);
	static SurveyDataType publicationDataType = new SurveyDataType(
	        "publication", false);
}
