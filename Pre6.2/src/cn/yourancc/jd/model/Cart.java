package cn.yourancc.jd.model;

import java.io.Serializable;

public class Cart  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long cartId;
	private Long cmId;
	private Integer count;
	public Long getCartId() {
		return cartId;
	}
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	public Long getCmId() {
		return cmId;
	}
	public void setCmId(Long cmId) {
		this.cmId = cmId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Cart(Long cartId, Long cmId, Integer count) {
		super();
		this.cartId = cartId;
		this.cmId = cmId;
		this.count = count;
	}
	public Cart() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
		result = prime * result + ((cmId == null) ? 0 : cmId.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (cartId == null) {
			if (other.cartId != null)
				return false;
		} else if (!cartId.equals(other.cartId))
			return false;
		if (cmId == null) {
			if (other.cmId != null)
				return false;
		} else if (!cmId.equals(other.cmId))
			return false;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		return true;
	}
	
	
}
