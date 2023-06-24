/*
 * 1) Дана строка sql-запроса "select * from students WHERE ". Сформируйте часть WHERE этого 
 * запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
Если значение null, то параметр не должен попадать в запрос.
String input_str = "{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}"
Ввод данных: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
вывод: select * from students WHERE name=Ivanov AND country=Russia AND city=Moscow
 */

 /**
  * program_1
  */
 public class program_1 {
 
    public static void main(String[] args) {
        StringBuilder sql = new StringBuilder ("select * from students WHERE ");
        String input_str = "{\"name\":\"Ivanov\",\"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        input_str = input_str.replace("{", "").replace("}", "").replace("\"", "").replace(" ", "");
        String[] input_filter = input_str.split(",");
        for (int n  = 0; n < input_filter.length; n++){
            if (input_filter[n].contains("null")) continue;
            else{
                sql.append(input_filter[n].replace(":", " = ") + "  ");
            }
        }


        sql.delete(sql.length()-2, sql.length());
        System.out.println(sql);
    }
 }