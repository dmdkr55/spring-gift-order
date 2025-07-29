package gift.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OrderRequest {

    @NotNull(message = "옵션 ID는 필수 입력 값입니다.")
    private Long optionId;
    @NotNull(message = "수량은 필수 입력 값입니다.")
    private Integer quantity;
    @NotBlank(message = "메시지는 필수 입력 값입니다.")
    private String message;

    private String imageUrl;

    protected OrderRequest() {
    }

    public OrderRequest(Long optionId, Integer quantity, String message) {
        this(optionId, quantity, message, null);
    }

    public OrderRequest(Long optionId, Integer quantity, String message, String imageUrl) {
        this.optionId = optionId;
        this.quantity = quantity;
        this.message = message;
        this.imageUrl = imageUrl;
    }

    public Long getOptionId() {
        return optionId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getMessage() {
        return message;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
