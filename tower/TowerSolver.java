package tower;

public class TowerSolver {
    private TowerModel model;

    public TowerSolver()
    {
        // Nothing to do here
    }

    public void solve(TowerModel model)
    {
        this.model = model;
        solve(model.getHeight(), 0, 2, 1);
        // Call the missing solve method (not this one)
    }

    // Create an overloaded solve(...) method
    // This new method will be recursive (call itself)
    //
    // [ solve method here]
    public void solve(int n, int from, int to, int aux){
        if(n <= 0){ 
            return; 
        }
    solve(n-1, from, aux, to);
    model.move(from, to);
    solve(n-1, aux, to, from);
}
}


