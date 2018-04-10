

@GenericGenerator(name="main-generator", strategy="increment", parameters = {
        @Parameter(name = "main-sequence", value = "main")
})
package com.odmytrenko;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;