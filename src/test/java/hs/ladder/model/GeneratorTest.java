package hs.ladder.model;

import org.junit.Assert;
import org.junit.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Console;

public class GeneratorTest {

	
	@Test
	public void testGenerateDifferent(){
		
		GameResult[] result = GameGenerator.generate(10, 0.6f);
		Assert.assertTrue(assertHasBothWinAndLoose(result));
	}
	
	@Test 
	public void testGenerate() {
		int N_TESTS=1000;
		int nWins=0;
		int nLooses=0;
		
		double winRate=0.6f;
		double winRateIntervalMin=0.52f;
		double winRateIntervalMax=0.62f;
		
		
		for (int i=0;i<N_TESTS;i++) {
			GameResult[] result=GameGenerator.generate(10, winRate);
			nWins+=getCount(result, GameResult.WIN);
			nLooses+=getCount(result, GameResult.LOOSE);
		}
		double ratio=(double)nWins/(double)(nWins+nLooses);
		
		System.out.print(ratio);
		Assert.assertTrue("ratio is "+ratio,ratio>winRateIntervalMin);
		Assert.assertTrue("ratio is "+ratio,ratio<winRateIntervalMax);
		
	}
	private int getCount(GameResult[] result,GameResult type) {
		int sum=0;
		for(int i=0;i<result.length;i++) {
			if(result[i]==type) {
				++sum;
			}
		}
		return sum;
	}
	private boolean assertHasBothWinAndLoose(GameResult[] result){
		
		boolean hasWin=false;
		boolean hasLoose=false;
		for(int i=0;i<result.length;i++) {
			if(!hasWin && result[i]==GameResult.WIN) {
				hasWin=true;
			}
			if(!hasLoose && result[i]==GameResult.LOOSE) {
				hasLoose=true;
			}
			if(hasLoose && hasWin) {
				return true;
			}
		}
		return false;
	}
}
