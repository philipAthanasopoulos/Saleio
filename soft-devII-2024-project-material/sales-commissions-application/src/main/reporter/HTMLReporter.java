package main.reporter;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;


public class HTMLReporter extends Reporter{
        @Override
        public File generateReport(File directory, ArrayList<String> tags, ArrayList<String> values ) throws Exception {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<html>\n")
                         .append("<head>\n")
                         .append(getStyle())
                         .append("</head>\n")
                         .append("<body>\n")
                         .append("<table>\n");
                         
            for(String tag : tags) 
                stringBuilder.append("<tr>\n")
                             .append("<td>")
                             .append(tag)
                             .append("</td>\n")
                             .append("<td>")
                             .append(values.get(tags.indexOf(tag)))
                             .append("</tr>\n")
                             .append("</td>\n");
                
            stringBuilder.append("</table>\n")
                         .append("</body>\n")
                         .append("</html>\n");

            File resultFile = new File(directory + "/Report.html");
            FileWriter fileWriter = new FileWriter(resultFile);
            fileWriter.write(stringBuilder.toString());
            fileWriter.close();

            return resultFile;
        }

        public String getStyle(){
            return "<style>\n" +
                    "table {\n" +
                    "  font-family: arial, sans-serif;\n" +
                    "  border-collapse: collapse;\n" +
                    "  width: 100%;\n" +
                    
                    "}\n" +
                    "\n" +
                    "td, th {\n" +
                    "  border: 1px solid #dddddd;\n" +
                    "  text-align: left;\n" +
                    "  padding: 8px;\n" +
                    "}\n" +
                    "\n" +
                    "tr:nth-child(even) {\n" +
                    "  background-color: #dddddd;\n" +
                    "}\n" +
                    "</style>";
        }
}
