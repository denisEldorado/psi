/**
 * 
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.ProductPrvTemplates;
import org.muhia.app.psi.orm.model.ProductsMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 *
 */
@Repository
public interface ProductPrvTemplatesRepository extends JpaRepository<ProductPrvTemplates, Long> {
    ProductPrvTemplates findProductPrvTemplatesByProductIdAndStatus(ProductsMaster productId, int status);

//	Organizations findbyOrganizationAndStatus(String organization, int status);
}
