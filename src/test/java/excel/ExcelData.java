package excel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExcelData {
	final static Logger logger = LogManager.getLogger("Excel");

	public String getNetworkData(String sheetName, int row, int column) {
		try {
			ExcelUtils.setExcelFile(Constant.PATH_NETWORKDATA, sheetName);
			String value = ExcelUtils.getCellData(row, column);
			return value;
		} catch (Exception e) {
			logger.error("" + e);
			return null;
		}

	}

	public String getLabInfo(String sheetName, int row, int column) {
		try {
			ExcelUtils.setExcelFile(Constant.PATH_LABDATA, sheetName);
			String value = ExcelUtils.getCellData(row, column);
			return value;
		} catch (Exception e) {
			logger.error("" + e);
			return null;
		}

	}

	public String getConfigurationSetting(String sheetName, int row, int column) {
		try {
			ExcelUtils.setExcelFile(Constant.PATH_CONFIGSETTING, sheetName);
			String value = ExcelUtils.getCellData(row, column);
			return value;
		} catch (Exception e) {
			logger.error("" + e);
			return null;
		}

	}

	public String getTestSetting(String sheetName, int row, int column) {
		try {
			ExcelUtils.setExcelFile(Constant.PATH_TEST, sheetName);
			String value = ExcelUtils.getCellData(row, column);
			return value;
		} catch (Exception e) {
			logger.error("" + e);
			return null;
		}
	}
	
	public String getTestData(String sheetName, int row, int column) {
		try {
			ExcelUtils.setExcelFile(Constant.PATH_TESTDATA, sheetName);
			String value = ExcelUtils.getCellData(row, column);
			return value;
		} catch (Exception e) {
			logger.error("" + e);
			return null;
		}

	}
	
	

}
