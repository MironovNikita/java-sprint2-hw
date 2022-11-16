import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        MonthToYear monthToYear = new MonthToYear();
        YearlyReport yearlyReport = new YearlyReport();

        boolean monthRead = false;
        boolean yearRead = false;

        System.out.println("Добро пожаловать в 2D бухгалтерию!");
        while (true) {
            printMenu();
            int userCommand;
            System.out.print("Введите команду (значение от 0 до 5): ");
            userCommand = checkIntInput(scanner);

            if(userCommand == 1) {
                if(!monthRead) {
                    System.out.println();
                    System.out.println("Выбрано: Считать все месячные отчёты");
                    System.out.println("Идёт обработка данных...");

                    File file = new File("resources");
                    File[] files = file.listFiles();
                    try {
                        for (File f : files) {
                            if (f.getName().charAt(0) == 'm') {
                                addListFromFile(monthToYear, f);
                            }
                        }
                    } catch (NullPointerException e) {
                        System.out.println("Файл не обнаружен: " + e.getMessage());
                    }
                    monthRead = true;
                    System.out.println("Считывание месячных отчётов завершено!");
                }
                else {
                    System.out.println();
                    System.out.println("Вы уже считали месячные отчёты!");
                }

            } else if(userCommand == 2) {
                if(!yearRead) {
                    System.out.println();
                    System.out.println("Выбрано: Считать годовой отчёт");
                    System.out.println("Идёт обработка данных...");

                    File file = new File("resources");
                    File[] files = file.listFiles();
                    try {
                        for (File f : files) {
                            if (f.getName().charAt(0) == 'y') {
                                addYearFromFile(yearlyReport, f);
                            }
                        }
                    } catch (NullPointerException e) {
                        System.out.println("Файл не обнаружен: " + e.getMessage());
                    }
                    yearRead = true;
                    System.out.println("Считывание годовых отчётов завершено!");
                }
                else {
                    System.out.println();
                    System.out.println("Вы уже считали годовые отчёты!");
                }
            } else if(userCommand == 3) {
                if (monthRead && yearRead) {
                    System.out.println();
                    System.out.println("Выбрано: Сверить отчёты");
                    System.out.println("Идёт обработка данных...");
                    System.out.println("Статистика по месяцам ");
                    monthToYear.printStatistics();
                    System.out.println();
                    System.out.println("Доходы за все месяцы: " + monthToYear.getIncome());
                    System.out.println("Расходы за все месяцы: " + monthToYear.getConsumption());
                    System.out.println();
                    int monthListSize = monthToYear.getMonthListSize();
                    if(monthListSize == yearlyReport.getIncomeSize() &&
                            monthListSize == yearlyReport.getConsumptionSize()) {
                        for (int i = 0; i < monthListSize; i++) {
                            System.out.println("Сравнение данных за " + (i+1) + "-й месяц: ");
                            int monthIncome = monthToYear.getIncomeByMonth(i);
                            int monthCons = monthToYear.getConsumptionByMonth(i);
                            int monthInYearIncome = yearlyReport.getMonthIncome(i);
                            int monthInYearCons = yearlyReport.getMonthConsumption(i);
                            System.out.println("Доход по месячному отчёту: " + monthIncome);
                            System.out.println("Доход по годовому отчёту: " + monthInYearIncome);
                            System.out.println("Расход по месячному отчёту: " + monthCons);
                            System.out.println("Расход по годовому отчёту: " + monthInYearCons);
                            if (monthIncome != monthInYearIncome || monthCons!= monthInYearCons) {
                                System.out.println("Обнаружена ошибка в " + (i+1) + "-м месяце!");
                                break;
                            } else {
                                System.out.println("Данные за " + (i+1) + " месяц верны.");
                                System.out.println();
                            }
                        }
                        System.out.println("Поздравляем! Все данные верны! :)");
                    } else {
                        System.out.println("Ошибка в исходных данных!");
                        System.out.println("Количество месячных отчётов не соответствует записям в годовом!");
                    }
                } else {
                    System.out.println();
                    System.out.println("Вы должны считать как месячные отчёты, так и годовой для сверки данных!");
                }
            } else if(userCommand == 4) {
                if(monthRead) {
                    System.out.println();
                    System.out.println("Выбрано: Вывести информацию о всех месячных отчётах");
                    System.out.println("Идёт обработка данных...");
                    System.out.println("Самый прибыльный товар по месяцам: ");
                    monthToYear.getMonthMostProfitProduct();
                    System.out.println("Самая большая трата по месяцам: ");
                    monthToYear.getMonthMostExpenseProduct();
                }
                else {
                    System.out.println();
                    System.out.println("Вы ещё не считали отчёты для вывода информации!");
                }
            } else if(userCommand == 5) {
                if(yearRead) {
                    System.out.println();
                    System.out.println("Выбрано: Вывести информацию о годовом отчёте");
                    String fileName = "";
                    File file = new File("resources");
                    File[] files = file.listFiles();
                    try {
                        for (File f : files) {
                            if (f.getName().charAt(0) == 'y') {
                                fileName = (f.getName()).substring(2, 6);
                                System.out.println("Выводится отчёт за " + fileName + " год...");
                                System.out.println("Идёт обработка данных...");
                                System.out.println();
                                System.out.println("Доходы по месяцам: ");
                                yearlyReport.printAllIncome();
                                System.out.println("Расходы по месяцам: ");
                                yearlyReport.printAllConsumption();
                                System.out.println();
                                int checkSize = yearlyReport.getYearBalance();
                                if (checkSize > 0) {
                                    for (int i = 0; i < checkSize; i++) {
                                        System.out.println("Прибыль за " + (i + 1) + "-й месяц: " + yearlyReport.getMonthProfit(i));
                                    }
                                } else {
                                    System.out.println("Ошибка в исходных данных!");
                                    System.out.println("Количество записей доходов не соответствует количеству записей расходов!");
                                }

                                System.out.println();
                                System.out.printf("Средний расход за все месяцы в году: %.2f %n", yearlyReport.getAverageMonthConsumption());
                                System.out.printf("Средний доход за все месяцы в году: %.2f %n", yearlyReport.getAverageMonthIncome());
                            }
                        }
                    } catch (NullPointerException e) {
                        System.out.println("Файл не обнаружен: " + e.getMessage());
                    }
                } else {
                    System.out.println();
                    System.out.println("Вы ещё не считали отчёты для вывода информации!");
                }
            } else if(userCommand == 0) {
                System.out.println("Выход");
                break;
            }
            else System.out.println("Извините, такая команда отсутствует :с");
        }
    }
    private static void printMenu() {
        System.out.println();
        System.out.println("Меню: ");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");
    }
    public static int checkIntInput(Scanner scanner) {
        boolean isInt;
        int num = 0;
        do {
            if (scanner.hasNextInt()){
                num = scanner.nextInt();
                isInt = true;
                break;
            }
            else {
                System.out.print("Не могу распознать число. Введите числовое значение: ");
                isInt = false;
                scanner.next();
            }
        } while (!(isInt));
        return num;
    }
    public static void addListFromFile(MonthToYear year, File file) throws Exception  {
        MonthlyReport month = new MonthlyReport();
        year.addMonth(month);
        FileReader reader = new FileReader(file);
        Scanner in = new Scanner(reader);
        String str = in.nextLine(); //пропуск первой строки
        while (in.hasNextLine()) {
            str = in.nextLine();
            String[] strArray = str.split(",");
            month.addProduct(new Product(strArray[0], Integer.parseInt(strArray[2]), Integer.parseInt(strArray[3])), Boolean.parseBoolean(strArray[1]));
        }
        in.close();
    }
    public static void addYearFromFile(YearlyReport yearlyReport, File file) throws Exception  {

        FileReader reader = new FileReader(file);
        Scanner in = new Scanner(reader);
        String str = in.nextLine(); //пропуск первой строки
        while (in.hasNextLine()) {
            str = in.nextLine();
            String[] strArray = str.split(",");
            yearlyReport.addYearString(new YearString(Integer.parseInt(strArray[0]), Integer.parseInt(strArray[1])), Boolean.parseBoolean(strArray[2]));
        }
        in.close();
    }
}
/* Семён, привет! Спасибо за подсказки :)
Стараюсь делать задание как можно раньше, чтобы было время на исправление в случае чего.
Округление сделал до двух знаков после запятой и ещё сделал проверку на NullPointerException)

 */
