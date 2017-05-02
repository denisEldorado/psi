/**
 * 
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;


import java.util.Collection;
import java.util.Optional;
import org.muhia.app.psi.orm.model.ProductParameters;
import org.muhia.app.psi.orm.model.ProductsMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 *
 */
@Repository
public interface ProductParametersRepository extends JpaRepository<ProductParameters, Long> {
	
    @Query("")
    Optional<Collection<ProductParameters>> findProductParametersByProductId(ProductsMaster productId) ;
    
     @Query("SELECT p FROM ProductParameters p WHERE p.productId = :productId")
    Optional<ProductParameters> findFirstProductParametersByProductId(@Param(value="productId")ProductsMaster productId) ;


    Optional<ProductParameters> findProductParametersBySmsKeyword(String smsKeyword);
}
