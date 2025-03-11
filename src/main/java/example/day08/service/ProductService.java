package example.day08.service;

import example.day08.model.dto.ProductDto;
import example.day08.model.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 스프링 빈 등록
public class ProductService {

    @Autowired private ProductMapper productMapper;

    // [2] 전체조회
    public List<ProductDto> onRead( ){
        System.out.println("ProductService.onRead");
        return productMapper.onRead();
    }

    // [1] 제품등록
    public boolean onCreate( ProductDto productDto ){
        System.out.println("ProductService.onCreate");
        System.out.println("productDto = " + productDto);
        return productMapper.onCreate( productDto );
    } // f end

    // [3] 제품수정
    public boolean onUpdate( ProductDto productDto ){
        System.out.println("ProductService.onUpdate");
        System.out.println("productDto = " + productDto);
        return productMapper.onUpdate( productDto );
    } // f end

    // [4] 제품삭제
    public boolean onDelete( int id ){
        System.out.println("ProductService.onDelete");
        System.out.println("id = " + id);
        return productMapper.onDelete( id );
    }
}












