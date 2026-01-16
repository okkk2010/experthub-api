

public class ExpertService {

    private final ExpertRepository expertRepository;

    public Response<ExpertDTO> getExpertById(Long id) {
        Optional<Expert> expertOpt = expertRepository.findById(id);
        if (expertOpt.isPresent()) {
            Expert expert = expertOpt.get();
            ExpertDTO expertDTO = mapToDTO(expert);
            return Response.<ExpertDTO>builder()
                    .data(expertDTO)
                    .message("Expert found")
                    .statusCode(200)
                    .build();
        } else {
            return Response.<ExpertDTO>builder()
                    .data(null)
                    .message("Expert not found")
                    .statusCode(404)
                    .build();
        }
    }

    public Response<List<ExpertDTO>> getAllExperts() {
        List<Expert> experts = expertRepository.findAll();
        List<ExpertDTO> expertDTOs = experts.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
        return Response.<List<ExpertDTO>>builder()
                .data(expertDTOs)
                .message("Experts retrieved successfully")
                .statusCode(200)
                .build();
    }
}
