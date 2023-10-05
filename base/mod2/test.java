public class test {
    public static void main(String[] args) {
        Player bot1 = new Player();
        Player bot2 = new Player();
        Player bot3 = new Player();

        Player igor = new Player(Player.VARIANTS.SCISSORS, "Igor");
        System.out.println(bot1.whoWins(bot1, igor));

        Player nika = new Player(Player.VARIANTS.SCISSORS, "Nika");
        System.out.println(bot2.whoWins(bot2, nika));

        Player lev = new Player(Player.VARIANTS.SCISSORS, "Lev");
        System.out.println(bot3.whoWins(bot3, lev));
    }
}
