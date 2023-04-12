public class CyclopsFactory implements AbstractEnemyFactory {
    @Override
    public Enemy createEnemy() {
        return new Cyclops();
    }
}
