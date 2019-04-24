/**
 * The purpose of this  Class
 */
package com.allison.shop.app;

/**
 * @author MichaelDev
 *
 */

public class ACHSchedularEntity {
	private final ACHBatchType achBatachType;
	private final Long uploadProfileId;
	private final Long fileId;
	private final Long profileId;
	
	/**
	 * Default Schedule Entity wrapper
	 * 
	 * @param achBatachType
	 * @param uploadProfileId
	 * @param fileId
	 * @param profileId
	 */
	public ACHSchedularEntity(final ACHBatchType achBatachType, 
							  final Long fileId, 
							  final Long profileId,
							  final Long uploadProfileId) {
		
		this.achBatachType = achBatachType;
		this.fileId = fileId;
		this.profileId = profileId;
		this.uploadProfileId = uploadProfileId;
	}
	public final Long getUploadProfileId() {
		return uploadProfileId;
	}
	public final ACHBatchType getAchBatachType() {
		return achBatachType;
	}
	public final Long getFileId() {
		return fileId;
	}
	public final Long getProfileId() {
		return profileId;
	}
	@Override
	public String toString() {
		return "ACHSchedularEntity [uploadProfileId=" + uploadProfileId + ", achBatachType=" + achBatachType
				+ ", fileId=" + fileId + ", profileId=" + profileId + "]";
	}
	
}
