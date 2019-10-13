/**
 * 
 */
package abhijeet.PrivateMethods;
/**
 * @author abhibane
 *
 */
public class PrivateMethods {
 
 
 private String CallingPrivateMethod(){
  return "Private Method";
 }
  
 public String CallingPublicMethod(){
  return CallingPrivateMethod();
 }
}
 
