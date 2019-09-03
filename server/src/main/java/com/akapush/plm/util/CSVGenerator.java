package com.akapush.plm.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.akapush.plm.domain.model.Young;
import com.opencsv.CSVWriter;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

@Component
public class CSVGenerator {

	public void generateYoungsCSV(HttpServletResponse response, Iterable<Young> youngs) {
		try {

			HeaderColumnNameMappingStrategy<Young> mapStrategy = new HeaderColumnNameMappingStrategy<Young>();
			mapStrategy.setType(Young.class);
			mapStrategy.generateHeader();

			String[] columns = new String[] { "id", "firstname", "lastname" };

			StatefulBeanToCsv<Young> btcsv = new StatefulBeanToCsvBuilder<Young>(response.getWriter())
					.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).withMappingStrategy(mapStrategy).withSeparator(',')
					.build();
			List<Young> youngsList = new ArrayList<>();
			for (Young young : youngs) {
				youngsList.add(young);
			}
			btcsv.write(youngsList);
		} catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
