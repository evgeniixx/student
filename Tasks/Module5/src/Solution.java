/*
В предложенной ниже задаче нужно посчитать площадь круга
по формуле s = pi * rad * rad. В данном коде есть две ошибки.

От вас требуется:
1. Загрузить код в свой репозиторий, в основную ветку,
2. Создать ветку, в которой вы исправите баг.
3. Смержить две ветки.

Правильный ответ:
1. Не импортирован класс Scanner.
2. Не осуществлено приведение приведение переменной s типа double.
к типу int
*/


public class Solution {
    public static void main(String[] args) {
        double pi = 3.14;
        Scanner scan = new Scanner(System.in);
        double rad = scan.nextDouble();
        double s = pi * Math.pow(rad, 2);
        System.out.println(s);
    }
}