
class FenwickTree {

	private int[] tree;
	private int size;
	
	public FenwickTree(int nodes) {
		size = nodes;
		tree = new int[size + 1];
	}
	
	public void update(int idx, int val) {
		while (idx <= size) {
			tree[idx] += val;
			idx += (idx & -idx);
		}
	}
	
	public int freqTo(int idx) {
		int sum = 0;

		while (idx > 0) {
			sum += tree[idx];
			idx -= (idx & -idx);
		}
		return sum;
	}
	
	public int freqAt(int idx) {
		int sum = tree[idx];
		int y, z;
		
		if (idx > 0) {
			z = idx - (idx & -idx);
			y = idx - 1;

			while (y != z) {
				sum -= tree[y];
				y -= (y & -y);
			}
		}
		return sum;
	}
}
