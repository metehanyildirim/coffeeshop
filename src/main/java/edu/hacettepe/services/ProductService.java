package edu.hacettepe.services;

import edu.hacettepe.DAO.Product;
import edu.hacettepe.repository.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService
{

    private Repository repository;

    // This function deletes a product and returns its id.
    public synchronized Product delete(int id) throws IOException
    {
        return repository.deleteProduct(id);
    }

    public Product find(int id) throws IOException{
        return repository.getProduct(id);
    }

    public synchronized Product add(Product product) throws IOException{
        return repository.addProduct(product);
    }

    public synchronized void update(Product product) throws IOException{
        repository.updateProduct(product);
    }

    public List<Product> list() throws IOException{
        return repository.listProducts();
    }

    public void setRepository(Repository repository)
    {
        this.repository = repository;
    }


}