public class CulcDestinyV {

	double m_pn;
	double m_p1;
	double m_n;

	CulcDestinyV() {
		Init();
	}

	public void Init() {
		m_pn = -1;
		m_p1 = -1;
		m_n = -1;
	}

	public void setValues(double pn, double p1, double n) {
		m_pn = (pn != -1) ? pn/100: -1;
		m_p1 = (p1 != -1) ? p1/100: -1;
		m_n = n;
	}

	public double[] getvalues() {
		double[] values = new double[3];

		values[0] = m_pn;
		values[1] = m_p1;
		values[2] = m_n;

		return values;
	}

	public boolean[] checkValIn() {
		boolean[] bools = new boolean[3];
		bools[0] = (m_pn != -1);
		bools[1] = (m_p1 != -1);
		bools[2] = (m_n != -1);
		return bools;
	}

	public void culcn() {

		m_n = Math.log(1 - m_pn) / Math.log(1 - m_p1);

	}
	
	public double getn(){
		return m_n;
	}
	
	public void culcpn(){
		m_pn = 1-Math.pow(1-m_p1, m_n);
	}
	
	public double getpn(){
		return m_pn*100;
		
	}
	
	
	public double getp1(){
		return m_p1*100;
	}

	
	

}
