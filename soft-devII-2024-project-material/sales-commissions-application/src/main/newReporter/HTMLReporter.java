package main.newReporter;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;


public class HTMLReporter extends Reporter{
        @Override
        public void createAndSaveReport(File directory, ArrayList<String> tags, ArrayList<String> values ) throws Exception {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<html>\n");
            stringBuilder.append("<head>\n");
            stringBuilder.append(getStyle());
            stringBuilder.append("</head>\n");
            stringBuilder.append("<body>\n");
            stringBuilder.append("<table>\n");
            for(String tag : tags) {
                stringBuilder.append("<tr>\n");
                stringBuilder.append("<td>");
                stringBuilder.append(tag);
                stringBuilder.append("</td>\n");
                stringBuilder.append("<td>");
                stringBuilder.append(values.get(tags.indexOf(tag)));
                stringBuilder.append("</td>\n");
                stringBuilder.append("</tr>\n");
            }
            stringBuilder.append("</table>\n");
            stringBuilder.append("</body>\n");
            stringBuilder.append("</html>\n");

            FileWriter fileWriter = new FileWriter(directory + "/Report.html");
            fileWriter.write(stringBuilder.toString());
            fileWriter.close();
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
