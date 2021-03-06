/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.model.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.archimatetool.model.IArchimateElement;
import com.archimatetool.model.IArchimateFactory;
import com.archimatetool.model.IArchimatePackage;
import com.archimatetool.model.util.ArchimateModelUtils;

import junit.framework.JUnit4TestAdapter;

@RunWith(Parameterized.class)
public class AllArchimateElementTypeTests extends ArchimateElementTests {
    
    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(AllArchimateElementTypeTests.class);
    }
    
    @Parameters
    public static Collection<EClass[]> eObjects() {
        List<EClass[]> list = new ArrayList<EClass[]>();
        
        for(EClass eClass : ArchimateModelUtils.getAllArchimateClasses()) {
            list.add(new EClass[] { eClass });
        }
        
        list.add(new EClass[] { IArchimatePackage.eINSTANCE.getAndJunction() });
        list.add(new EClass[] { IArchimatePackage.eINSTANCE.getOrJunction() });
        
        return list;
    }
    
    private EClass eClass;
    
    public AllArchimateElementTypeTests(EClass eClass) {
        this.eClass = eClass;
    }
    
    @Override
    protected IArchimateElement getArchimateConcept() {
        return (IArchimateElement)IArchimateFactory.eINSTANCE.create(eClass);
    }
}
