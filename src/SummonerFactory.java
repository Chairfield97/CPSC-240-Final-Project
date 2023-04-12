public class SummonerFactory implements AbstractEnemyFactory {
    @Override
    public Enemy createEnemy() {
        return new Summoner();
    }
}
