public class BoarFactory implements AbstractEnemyFactory {
    @Override
    public Enemy createEnemy() {
        return new Boar();
    }
}
