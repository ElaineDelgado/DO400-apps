package com.redhat.shopping.integration.blackbox;
import com.redhat.shopping.cart.AddToCartCommand;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
import java.util.Random;
import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.given;

@QuarkusTest
public class ShoppingCartTest {   

        private int randomQuantity() {        
                return (new Random()).nextInt(10) + 1;
        }    

        private void addProductToTheCartWithIdAndRandomQuantity(int productId) {        
                AddToCartCommand productToAdd = new AddToCartCommand(            
                        productId,            
                        this.randomQuantity()        
                );  

                given()            
                .contentType("application/json")          
                .body(productToAdd)         
                .put("/cart");    
        }    
        
        @BeforeEach    public void clearCart() {
                delete("/cart");   
         } 
        // @todo: add integration tests
}
