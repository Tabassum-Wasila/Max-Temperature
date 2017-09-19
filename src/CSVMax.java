import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class CSVMax {
	public CSVRecord hottestHourInDay(CSVParser parser)
	{
		CSVRecord largestSoFar = null;
		for(CSVRecord currentRow : parser)
		{
			if(largestSoFar == null)
				largestSoFar = currentRow;
			else
			{
				double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
				double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
				if(currentTemp > largestTemp)
					largestSoFar = currentRow;
			}
		}
		return largestSoFar;
	}
	public void testHottestHourInDay()
	{
		FileResource fr = new FileResource("C://Users/Tabassum Wasila Sus/Downloads/nc_weather/nc_weather/2012/weather-2012-01-01.csv");
		CSVRecord largest = hottestHourInDay(fr.getCSVParser());
	}
	public CSVRecord hottestInYear()
	{
		DirectoryResource dr = new DirectoryResource();
		CSVRecord largestSoFar = null;
		for(File f: dr.selectedFiles())
		{
			FileResource fr = new FileResource(f);
			CSVRecord current = hottestHourInDay(fr.getCSVParser());
			if(largestSoFar == null)
				largestSoFar = current;
			else
			{
				double currentTemp = Double.parseDouble(current.get("TemperatureF"));
				double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
				if(currentTemp > largestTemp)
					largestSoFar = current;
			}
			
		}
		return largestSoFar;
	}
	public void testHottestDayInYear()
	{
		CSVRecord largest = hottestInYear();
		System.out.println("Hottest Temperature was " + largest.get("TemperatureF") + " at " + largest.get("DateUTC"));
	}
	public static void main(String[] args)
	{
		CSVMax c = new CSVMax();
		c.testHottestDayInYear();
	}
}
