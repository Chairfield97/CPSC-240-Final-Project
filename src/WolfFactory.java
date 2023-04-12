public class WolfFactory implements AbstractEnemyFactory {
    @Override
    public Enemy createEnemy() {
        return new Wolf();
    }
}
