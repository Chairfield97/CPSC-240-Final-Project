// inherited from AbstractEnemyFactory
public class CyclopsFactory implements AbstractEnemyFactory {
    //supposed to return a cyclops
    @Override
    public Enemy createEnemy() {
        return new Cyclops();
    }
}
